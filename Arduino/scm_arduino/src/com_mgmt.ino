

#include "UART.h"
#include "dispense.h"
#include "typedefs.h"
#include "com_mgmt.h"

typedef struct
{
	uint8 cmd;
	void (*dispenseFunc)();
}command;

command cmdTable[] = 
{
	{0xe2, makeCoffee},
	{0xe3, dispWater}
}

/************************************************************************************/
/* acceptSerialCommand(): attempts to get a serial byte from the UART, if there is one,
 * 						  then this subroutine attempts to find the command entry in the
 *                        cmdTable where the cmd is equal to the byte provided and
 *                        executes the corresponding function.            
 */
/************************************************************************************/
void acceptSerialCommand()
{
	static cmdTableSize = sizeof(cmdTable)/sizeof(command);
	int16 serialByteBuf = getSerialByte();
	uint8 serByte;
	uint8 i;
	
	if ( serialByteBuf != -1 )
	{
		serByte = serialByteBuf & 0xff;
		
		for ( i = 0; i < cmdTableSize; i++ )
		{
			if ( cmdTable[i].cmd == serByte )
			{
				cmdTable[i].dispenseFunc();
			}
		}
	}
}