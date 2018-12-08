#include <avr/io.h>
#include <util/delay.h>
#include <String.h>

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
    char *name1 = "E/14/141 - Ihalagedara IPSB";
    char *name2 = "E/14/154 - Jayasundara JMSA";
    char *name3 = "E/14/194 - Lokuge S.D";

    while(1){
        for(i=0;i<strlen(name1);i++){
            usart_send(name1[i]);
        }
        usart_send('\n');
        for(i=0;i<strlen(name2);i++){
            usart_send(name2[i]);
        }
        usart_send('\n');
        for(i=0;i<strlen(name3);i++){
            usart_send(name3[i]);
        }
        usart_send('\n');
        usart_send('\n');

        _delay_ms(BLINK_DELAY_MS);
    }





    return 0;
}