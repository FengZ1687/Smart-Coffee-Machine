
#ifndef TEMPERATURE_INCLUDED
#define TEMPERATURE_INCLUDED

#define WP_TEMP A1
#define CP_TEMP A7

void initTemp();
float getTemp(uint8 pin);

#endif