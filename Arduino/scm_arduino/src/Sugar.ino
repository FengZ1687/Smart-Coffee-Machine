
#include <Servo.h>
#include "Sugar.h"

/* Servo type to control the servo
   motor in charge of dispensing the
   sugar
   */
Servo sDisp;

void initSugar()
{
	/* Init the servo pin */
    sDisp.attach(DP_SERVO);
	
	/* Make sure the dispensor is closed */
    sDisp.write(0);
}

/************************************************************************************/
/* dispenseSugar(): opens the sugar latch temporarily to let sugar fall into the cup
 * 
 * param: duration - duration to keep the latch open, this number is multiplied by 
 *                   DURATION_FACTOR to get the delay, in ms
 */
/************************************************************************************/
bool dispenseSugar(uint32 duration)
{
  sDisp.write(40);
  delay(duration*DURATION_FACTOR);
  sDisp.write(0);

  return true;
}