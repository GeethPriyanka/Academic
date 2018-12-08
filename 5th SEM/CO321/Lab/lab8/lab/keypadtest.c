/******************************************************************************
2
3     Program to learn the use of Multiplexed 4x3 keypad with AVR Microcontroller.
4
5     Specific Skills Required
6        >> AVR GPIO details.(http://bit.ly/aq3ouw)
7        >> LCD Library.(http://bit.ly/agVUVc)
8        >> Operations on bits using C.(http://bit.ly/aFqg5n)
9
10
11    General Skills Required
12       >> AVR Studio Setup and use. (http://bit.ly/aZ43SZ)
13       >> avr-gcc setup and use.
14
15
16    Hardware
17    --------
18    ATmega32 @ 16MHz external crystal.
19    Fuse Byte setting HIGH = C9 and LOW = FF (MOST IMP.)
20
21
22    LCD   <->   AVR Connection
23
24       VSS ->GND
25       VDD ->+5V
26       VEE -> CENTER PIN OF 10K POT (OTHER TWO PIN OF POT TO +5V AND GND)
27             ADJ. THE POT UNTIL YOU HAVE A CLEAR TEXT DISPLAY.
28
29       RS -> PD3
30       RW -> PD6
31       E  -> PB4
32
33       DB0 -> N/C
34       DB1 -> N/C
35       DB2 -> N/C
36       DB3 -> N/C
37
38       DB4 -> PB0
39       DB5 -> PB1
40       DB6 -> PB2
41       DB7 -> PB3
42
43       LED+ ->+5V (VIA 100 OHM RES)
44       LED- ->GND
45
46    KEYPAD
47
48       COL1 ->  PA6
49       COL2 ->  PA5
50       COL3 ->  PA4
51
52       ROW1 ->  PA3
53       ROW2 -> PA2
54       ROW3 ->  PA1
55       ROW4 -> PA0
56
57                                NOTICE
58                               --------
59    NO PART OF THIS WORK CAN BE COPIED, DISTRIBUTED OR PUBLISHED WITHOUT A
60    WRITTEN PERMISSION FROM EXTREME ELECTRONICS INDIA. THE LIBRARY, NOR ANY PART
61    OF IT CAN BE USED IN COMMERCIAL APPLICATIONS. IT IS INTENDED TO BE USED FOR
62    HOBBY, LEARNING AND EDUCATIONAL PURPOSE ONLY. IF YOU WANT TO USE THEM IN
63    COMMERCIAL APPLICATION PLEASE WRITE TO THE AUTHOR.
64
65
66    WRITTEN BY:
67    AVINASH GUPTA
68    me@avinashgupta.com
69
70
71
72    ******************************************************************************/

    #include <avr/io.h>
    #include <util/delay.h>

    #include "lcd.h"
    #include "myutils.h"

    #define KEYPAD A  //KEYPAD IS ATTACHED ON PORTA

    //Don't Touch the lines below
    //*******************************
    #define KEYPAD_PORT PORT(KEYPAD)
    #define KEYPAD_DDR   DDR(KEYPAD)
    #define KEYPAD_PIN   PIN(KEYPAD)
    //*******************************


    /*******************************************
91
92    Function return the keycode of keypressed
93    on the Keypad. Keys are numbered as follows
94
95    [00] [01] [02]
96    [03] [04] [05]
97    [06] [07] [08]
98    [09] [10] [11]
99
100   Arguments:
101      None
102
103   Return:
104      Any number between 0-11 depending on
105      keypressed.
106
107      255 (hex 0xFF) if NO keypressed.
108
109   Precondition:
110      None. Can be called without any setup.
111
112   *******************************************/
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


   void main()
   {
      //Wait for LCD To Start
      _delay_loop_2(0);

      //Now initialize the module
      LCDInit(LS_NONE);


      uint8_t key;

      while(1)
      {
         key=GetKeyPressed(); //Get the keycode of pressed key

         LCDWriteIntXY(0,0,key,3);  //Print it at location 0,0 on LCD.
      }

   }