
#ifndef VALVE_INCLUDED
#define VALVE_INCLUDED

#define WP_VALVE A4
#define CP_VALVE A2

void initValve();
bool openValveForDuration(uint8 pin, uint32 duration);
void openValve(uint8 pin);
void closeValve(uint8 pin);

#endif