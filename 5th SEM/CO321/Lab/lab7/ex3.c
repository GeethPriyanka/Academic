#include <avr/io.h>
#include <util/delay.h>
#include <String.h>
#include <ctype.h>

#define BLINK_DELAY_MS 1000

void usart_init(){
    UCSR0B |= (1<<TXEN0) | (1<<RXEN0) ; // setting up the transmitter
    UCSR0C &= ~(1<<UMSEL00); // asynchronous mode
    UCSR0C &= ~(1<<UMSEL01);
    UCSR0C = (3<<UCSZ00); // 8 bit

    UBRR0H = 0; // setup the baud rate
    UBRR0L = 104;


}

void usart_send( unsigned char data){

    while((UCSR0A & (1<<UDRE0)) == 0){;}
    UDR0 = data;

}

unsigned char usart_recieve(){

    while(!(UCSR0A & (1<<RXC0))){;}
    return UDR0;

}


int main (void){

    usart_init();
    int i;


    while(1){
        unsigned char a;
        i = 0;
        char in[255];
        while ((a = usart_recieve()) != 13){
            in[i++] = a;
        }
        in[i] = '\0';

        for(i=0;i<strlen(in) || in[i] != '\0';i++){
            if(isalpha(in[i]) && isupper(in[i])){
                in[i] = ((in[i] - 'A' + 3)%26 ) + 'A';
            } else if(isalpha(in[i]) && islower(in[i])){
                in[i] = ((in[i] - 'a' + 3)%26 ) + 'a';
            }
        }

        for(i=0;i<strlen(in) || in[i] != '\0';i++){
           usart_send(in[i]);
        }
        usart_send('\n');
        _delay_ms(BLINK_DELAY_MS);
    }





    return 0;
}