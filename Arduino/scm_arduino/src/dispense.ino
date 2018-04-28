
#include "heat_mgmt.h"
#include "Valve.h"
#include "Sugar.h"
#include "dispense.h"

/************************************************************************************/
/* makeCoffee(): acquires remaining parameters from the serial line and attempts to
 *               make a coffee as desired
 */
/************************************************************************************/
bool makeCoffee()
{
    uint8 parameters[NUM_COFFEE_PARAMS];
    uint8 i;
    bool success;
    float temp;
    
    success = acquireParameters( NUM_COFFEE_PARAMS, SERIAL_TIMEOUT_VALUE, parameters );
    
    if (!success) {
      /* Message was transmitted in the acquireParameters function */
      return false;
    }
    /* Temperature range is 20 to 80,
     * 20 -> 0
     * 80 -> 255
     * */
    temp = (float)  ((uint16)parameters[3]) *10;
    
    /* This prevents our heater from staying on too long */
    if ( temp > 40 )
    {
      temp = 40;
    }
    heatCoffeeToTemp( temp );
    
    for ( i = 0; i < 3; i++ )
	{
		if ( parameters[i] > 10 )
		{
			parameters[i] = 10;
		}
	}
	/* Dispense */
	openValveForDuration(CP_VALVE, parameters[0]);
    dispenseSugar( parameters[1] );
    openValveForDuration(parameters[2]);
    
    /* Success! */
    return true;
}

/************************************************************************************/
/* dispWater():  acquires remaining parameters from the serial line and attempts to
 *               dispense the desired amount of water
 */
/************************************************************************************/
bool dispWater()
{
  bool success;
  uint8 parameters[NUM_WATER_PARAMS];
  
  success = acquireParameters( NUM_WATER_PARAMS, SERIAL_TIMEOUT_VALUE, parameters );

  if (!success) {
    /* Message was transmitted in the acquireParameters function */
    return false;
  }
  openValveForDuration( WP_VALVE,
                        parameters[0]
                      );

  /* Success! */
  return true;
}
