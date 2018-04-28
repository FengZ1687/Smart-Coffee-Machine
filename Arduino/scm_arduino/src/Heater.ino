
#include "Heater.h"

void initHeater()
{
	pinMode(CP_HEATER, OUTPUT);
}

void turnOnHeater()
{
  digitalWrite(CP_HEATER, HIGH);
}

void turnOffHeater()
{
  digitalWrite(CP_HEATER, LOW);
}