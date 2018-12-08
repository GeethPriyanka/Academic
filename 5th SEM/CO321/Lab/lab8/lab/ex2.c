#include <avr/io.h>
#include <util/delay.h>
#include <String.h>

#include "lcd.h"
#include "myutils.h"

#define KEYPAD B  //KEYPAD IS ATTACHED ON PORTA

//Don't Touch the lines below
//*******************************
#define KEYPAD_PORT PORT(KEYPAD)
#define KEYPAD_DDR   DDR(KEYPAD)
#define KEYPAD_PIN   PIN(KEYPAD)

#define BLINK_DELAY_MS 1000

uint8_t GetKeyPressed()
{
    uint8_t r,c;

    KEYPAD_PORT|= 0X0F;

    for(c=0;c<3;c++)
    {
        KEYPAD_DDR&=~(0X7F);

        KEYPAD_DDR|=(0X40>>c);
        for(r=0;r<4;r++)
        {
            if(!(KEYPAD_PIN & (0X08>>r)))
            {
                return (r*3+c);
            }
        }
    }

    return 0XFF;//Indicate No key pressed
}

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

void EEPROMwrite(unsigned int address,char data){
	//wait for completion of previous write
	while(EECR & (1<<EEPE));
	
	//set up address and data regs
	EEAR=address;
	EEDR=data;
	
	//write logical 1 to EEMPE
	EECR |= (1<<EEMPE);
	
	//start
	EECR |=(1<<EEPE);
}

char EEPROMread(unsigned int address){
	while(EECR & (1<<EEPE));
	EEAR=address;
	EECR |= (1<<EERE);
	return EEDR;
}
int main (void){

    usart_init();
    int i;
	unsigned int address=1;

    //Wait for LCD To Start
    _delay_loop_2(0);

    //Now initialize the module
    lcd_init(LCD_DISP_ON);
    lcd_clrscr();
    lcd_puts("Welcome! \n");
    _delay_ms(1000);
    lcd_clrscr();


    lcd_puts_P( "Encrypt(1) or change\n" );
    lcd_puts_P( "secret key(2) ?" );

    uint8_t key;

    //select options
    while(1){
        key = GetKeyPressed();
        if(key == 1 || key == 2){
            lcd_clrscr();
            lcd_putc(key);
            _delay_ms(500);
            break;
        }
    }

    //to change secret key
    if(key == 2){
        lcd_clrscr();
        lcd_puts("Enter new key:");
        lcd_gotoxy(0,1);

    }

    while(1){
        unsigned char a;
        i = 0;
        char in[255];
        while ((a = usart_recieve()) != 13){
            in[i++] = a;
        }
        in[i] = '\0';
        
        for(i=0;i<strlen(in) || in[i] != '\0';i++){
           EEPROMwrite(address,in[i]);
           address++;
        }

		for(i=1;i<address;i++){
			usart_send(EEPROMread(i));
		}
        usart_send('\n');
        _delay_ms(BLINK_DELAY_MS);
        address=1;
    }

    return 0;
}
