
#include "typedefs.h"
#include "UART.h"

void initUart()
{
	/* Init the serial line at
	   9600 baud
	   */
	Serial.begin(9600);
}

/************************************************************************************/
/* getSerialByte(): if there is a byte available for the UART line, read it and
 * 					return it, otherwise return -1
 * 
 * param: (none)
 */
/************************************************************************************/
int16 getSerialByte()
{
	return Serial.available() > 0 ? Serial.read() : -1;
}

/************************************************************************************/
/* acquireParameters(): attempts to acquire parameters from the serial line. these
 *                      parameters are returned in the buf
 * 
 * param: numParams - number of parameters to acq
 *        timeout   - function will stop after timeout ms
 *        buf       - means to return the data
 */
/************************************************************************************/
bool acquireParameters( uint8 numParams, uint32 timeout, uint8 *buf )
{
  uint32 timeoutCounter = 0;
  uint16 i;
  
  for ( i = 0; i < numParams; i++)
  {
    /* Acquire coffee parameters from the serial line */
    while (    ( !Serial.available() ) 
            || ( timeoutCounter > timeout ) 
          )
    {
      delay(1);
      timeoutCounter++;
    }
  
    if ( timeoutCounter > timeout )
    {
      transactionFailed("Did not receive all bytes for the parameters before timeout");
      return false;
    }
    buf[i] = Serial.read();
  }
  return true;
}

/************************************************************************************/
/* transactionFailed(): Something failed in the making of the coffee, send a message
 *                      back to the pi
 * 
 * param: msg - error message
 */
/************************************************************************************/
void transactionFailed(String msg)
{
  Serial.print("Error in transmission: ");
  Serial.println(msg);
}

