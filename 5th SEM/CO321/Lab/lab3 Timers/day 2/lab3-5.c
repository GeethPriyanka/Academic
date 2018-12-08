#include <avr/io.h>

void delay_timer0(){
	TCNT1 = 34285;

	TCCR1A = 0x00;
	TCCR1B = 0x03;

	while((TIFR1 & 0x01)==0);

	TCCR1A = 0x00;
	TCCR1B = 0x00;

	TIFR1 = 0x01;
}

int main (void){
DDRB = DDRB|(1<<5);
DDRB = DDRB|(1<<4);
DDRB = DDRB|(1<<3);
DDRB = DDRB|(1<<2);
DDRB = DDRB|(1<<1);

int i;
		PORTB = PORTB &~(1<<5);
		PORTB = PORTB &~(1<<4);
		PORTB = PORTB &~(1<<3);
		PORTB = PORTB &~(1<<2);
		PORTB = PORTB &~(1<<1);
		
/* configure pin 5 of PORTB for output*/
while(1){
	PORTB = PORTB | (1<<5);

	for(i=4;i>=1;i--){

		PORTB = PORTB | (1<<i);

		/* set pin 5 high to turn led on */
		delay_timer0();

		PORTB = PORTB &~(1<<i);
		
	}

	delay_timer0();
	PORTB = PORTB &~(1<<5);

	for(i=2;i<=3;i++){

		PORTB = PORTB | (1<<i);

		/* set pin 5 high to turn led on */
		delay_timer0();

		PORTB = PORTB &~(1<<i);
		
	}
delay_timer0();

}
}