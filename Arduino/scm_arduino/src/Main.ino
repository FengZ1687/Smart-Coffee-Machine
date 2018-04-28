
/* Include the hardware components */
#include "UART.h"
#include "Valve.h"
#include "Sugar.h"
#include "Heater.h"
#include "Temperature.h"

/* Include the functional components */
#include "com_mgmt.h"
#include "heat_mgmt.h"

void setup() 
{
	/* Initialize the hardware components */
	initUart();
	initValve();
	initSugar();
	initHeater();
	initTemp();
}

void loop() 
{
	/* Contiously invoke the two
	 * two tasks 
	 * */
	acceptSerialCommand();
	heat();
}