#include <avr/io.h>
int main (void){
    unsigned char result;
    DDRD = 0xFF; // set p p ort B for output
    DDRC &= ~(1<<2);
    // Configure the ADC module of the ATmega16
    ADMUX = (1<<ADLAR)|(1<<MUX0); // REFS1:0 = 00 -> AVCC as external,
    // ADLAR = 1 -> Left adjust
    // MUX4:0 = 00001 -> ADC1 as input
    ADCSRA = 0b10000111; // ADEN = 1: enable ADC,
    // ADSC = 0: don't start conversion yet
    // ADATE = 0: disable auto trigger,
    // ADIE 0 disable ADC interrupt = 0: disable ADC interrupt
    // ASPS2:0 = 111: prescaler = 128

    while(1){ // main loop
        // Start conversion by setting flag ADSC
        ADCSRA |= (1 << ADSC);

        // Wait until conversion is completed
        while (ADCSRA & (1 << ADSC)){;}
        // Read the top 8 bits, output to PORTB
        result = ADCH;
        if(result>(700>>2)){
            PORTD |= (1<<2);
        }else{
            PORTD &= ~(1<<2);
        }
    }

    return 0;
}