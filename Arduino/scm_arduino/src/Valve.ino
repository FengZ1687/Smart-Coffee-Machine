
#include "Valve.h"

void initValve()
{
	/* Make sure the output pins are
     * set to output 
     * */
	pinMode(CP_VALVE, OUTPUT);
	pinMode(WP_VALVE, OUTPUT);
	
	/* Make sure the valves are closed */
	digitalWrite(CP_VALVE, LOW);
	digitalWrite(WP_VALVE, LOW);
}

/************************************************************************************/
/* openValveForDuration(): opens a valve for a gives duration in ms, doesn't check 
 *                         whether the input is valid
 * 
 * param: duration - open duration in ms
 *        pin      - CP_TEMP for coffee sensor, WP_TEMP for water sensor
 */
/************************************************************************************/
bool openValveForDuration(uint8 pin, uint32 duration)
{ 
  openValve(pin);
  delay(duration);
  closeValve(pin);

  return true;
}

/************************************************************************************/
/* openValve(): opens a valve, doesn't check whether the input is valid
 * 
 * param: pin - CP_TEMP for coffee sensor, WP_TEMP for water sensor
 */
/************************************************************************************/
void openValve(uint8 pin)
{
  digitalWrite(pin, HIGH);
}

/************************************************************************************/
/* closeValve(): closes a valve, doesn't check whether the input is valid
 * 
 * param: pin - CP_TEMP for coffee sensor, WP_TEMP for water sensor
 */
/************************************************************************************/
void closeValve(uint8 pin)
{
  digitalWrite(pin, LOW);
}