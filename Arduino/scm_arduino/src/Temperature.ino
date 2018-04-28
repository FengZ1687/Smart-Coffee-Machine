
#include <OneWire.h> 
#include <DallasTemperature.h>
#include "Temperature.h"

/* Types used to control the temperature
  sensors
 */
OneWire c1w(CP_TEMP); 
OneWire w1w(WP_TEMP);

/* cs: Coffee sensor */
DallasTemperature csTemp(&c1w);
DallasTemperature wsTemp(&w1w);

void initTemp()
{
	pinMode(CP_TEMP, INPUT);
	pinMode(WP_TEMP, INPUT);
	
	csTemp.begin(); 
	wsTemp.begin();
}

/************************************************************************************/
/* getTemp(): Requests temp from a sensor
 * 
 * param: pin - CP_TEMP for coffee sensor, WP_TEMP for water sensor
 */
/************************************************************************************/
float getTemp(uint8 pin)
{
  float temp = -1;

  if ( pin == CP_TEMP )
  {
    csTemp.requestTemperatures();
    temp = csTemp.getTempCByIndex(0);
  }
  else if ( pin == WP_TEMP )
  {
    wsTemp.requestTemperatures();
    temp = wsTemp.getTempCByIndex(0);
  }
  return temp;
}