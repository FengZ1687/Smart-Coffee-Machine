
#include "typedefs.h"
#include "Heater.h"
#include "Temperature.h"
#include "heat_mgmt.h"

#define HEATING_THRESHOLD 35
#define HEATING_TIMEOUT_VALUE 20000

typedef enum
{
  HEATING,
  WAITING
}HEATER_STATE;

/************************************************************************************/
/* heat(): Turns the heater on until the coffee has reached HEATING_THRESHOLD
 *         temperature. The subroutine turns the heater off every HEATING_TIMEOUT_VALUE
 *         such that the components are not melted by the continuous high current.
 */
/************************************************************************************/
void heat()
{
  static HEATER_STATE state = WAITING;
  static uint64 transistionTime = millis();
  float temp;

  if ( state == WAITING )
  {
    csTemp.requestTemperatures(); 
    temp = getTemp(CP_TEMP);
    Serial.print("Coffee temp = ");
    Serial.println(temp);
    
    if ( millis() - transistionTime > HEATING_TIMEOUT_VALUE/4
        && ( temp < HEATING_THRESHOLD ))
    {
      state = HEATING;
      turnOnHeater();

      transistionTime = millis();
    }
  }
  else if ( state == HEATING )
  {
    if ( millis() - transistionTime > HEATING_TIMEOUT_VALUE  )
    {
      state = WAITING;
      turnOffHeater();

      transistionTime = millis();
    }
  }
}

/************************************************************************************/
/* heatCoffeeToTemp(): Turns the heater on until the temperature as attained
 *                     requestedTemp degrees.
 * 
 * param: requestedTemp - ...
 */
/************************************************************************************/
bool heatCoffeeToTemp(float requestedTemp)
{
  float reqTemp = requestedTemp;
  float temp;

  uint32 timeStarted;
  
  csTemp.requestTemperatures(); 
  delay(20);
  temp = getTemp(CP_TEMP);
  
  if ( temp < reqTemp )
  {
    turnOnHeater();
    timeStarted = millis();
     
    /* Wait for the coffee to be heated */
    while (   ( getTemp(CP_TEMP) < reqTemp )
           && ( millis() - timeStarted < HEATING_TIMEOUT_VALUE )
          )
    {
      csTemp.requestTemperatures();
    }
    turnOffHeater();
  }
  return true;
}