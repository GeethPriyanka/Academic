#include <avr/io.h>

void delay_timer0(){
	TCNT1 = 0;

	TCCR1A = 0x00;
	TCCR1B = 0x05;

	while((TIFR1 & 0x01)==0);

	TCCR1A = 0x00;
	TCCR1B = 0x00;

	TIFR1 = 0x01;
}

int main(void){
	DDRB = DDRB | (1<<5);

	while(1){
		PORTB = PORTB ^ (1<<5);
		delay_timer0();
	}
}