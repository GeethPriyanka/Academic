
#include <avr/io.h>

void delay_timer0(){ //50ms
	int i;
	for (i = 0; i < 10; i++)
	{
		/* code */
		TCNT0 = 178;

		TCCR0A = 0x00;
		TCCR0B = 0x05;

		while((TIFR0 & 0x01)==0);

		TCCR0A = 0x00;
		TCCR0B = 0x00;

		TIFR0 = 0x01;
	}
	
}

void delay_timer1(){ //50ms
	int i;
	for (i = 0; i < 1; i++)
	{
		/* code */
		TCNT1 = 53035;

		TCCR1A = 0x00;
		TCCR1B = 0x03;

		while((TIFR1 & 0x01)==0);

		TCCR1A = 0x00;
		TCCR1B = 0x00;

		TIFR1 = 0x01;
	}
	
}

int main(void){
	int j;
	DDRB = DDRB | (1<<5);
	DDRB = DDRB | (1<<4);

	while(1){
		PORTB = PORTB ^ (1<<5);
		for (j = 0; j < 10; j++)
		{
			/* code */
			PORTB = PORTB ^ (1<<4);
			delay_timer1();
		}
		
	}
}