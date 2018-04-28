
#ifndef UART_INCLUDED
#define UART_INCLUDED

void initUart();
int16 getSerialByte();
bool acquireParameters( uint8 numParams, uint32 timeout, uint8 *buf );
void transactionFailed(String msg);

#endif