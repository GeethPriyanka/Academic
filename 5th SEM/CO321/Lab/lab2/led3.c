#include <avr/io.h>
#include <util/delay.h>
#define BLINK_DELAY_MS 50
int main (void){
DDRB = DDRB|(1<<5);
DDRB = DDRB|(1<<4);
DDRB = DDRB|(1<<3);
DDRB = DDRB|(1<<2);

int i;
		PORTB = PORTB &~(1<<5);
		PORTB = PORTB &~(1<<4);
		PORTB = PORTB &~(1<<3);
		PORTB = PORTB &~(1<<2);
		
/* configure pin 5 of PORTB for output*/
while(1){

	for(i=5;i>=2;i--){

		PORTB = PORTB | (1<<i);

		/* set pin 5 high to turn led on */
		_delay_ms(BLINK_DELAY_MS);

		PORTB = PORTB &~(1<<i);
		
	}
	_delay_ms(BLINK_DELAY_MS);

	for(i=3;i<=4;i++){

		PORTB = PORTB | (1<<i);

		/* set pin 5 high to turn led on */
		_delay_ms(BLINK_DELAY_MS);

		PORTB = PORTB &~(1<<i);
		
	}
_delay_ms(BLINK_DELAY_MS);

}
}