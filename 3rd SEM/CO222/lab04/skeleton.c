#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define RESET		0
#define BRIGHT 		1

#define BLACK 		0
#define RED			1
#define GREEN		2
#define YELLOW		3
#define BLUE		4
#define MAGENTA		5
#define CYAN		6
#define	WHITE		7


void textcolor(int attr, int fg, int bg);

void textcolor(int attr, int fg, int bg)
{	char command[13];

	/* Command is the control command to the terminal */

	/* textcolor(BRIGHT,BLACK,WHITE) will have characters printed in
	black in white background */
	sprintf(command, "%c[%d;%d;%dm", 0x1B, attr, fg + 30, bg + 40);
	printf("%s", command);
}





int main(int argc, char **argv){
	
	int u,v,w1,w2,w3,w4,w5,w6,w7,w8,x1,x2,x3,x4,x5,x6,x7,x8, count1,count2,count3,count4,count5;
	char str1[] = "checker";
	char str2[] = "donut";
	char str3[] = "black";
	char str4[] = "red";	
	char str5[] = "green";
	char str6[] = "yellow";
	char str7[] = "blue";
	char str8[] = "magenta";
	char str9[] = "cyan";
	char str10[]= "white";
	
	

	if(argc>4){
		printf("Too many arguments");
	}else if(argc<4){
		printf("Not enough arguments");
	}else if(argc=4){
		
		u = strcmp(argv[1],str1);
		v = strcmp(argv[1],str2);
		w1 = strcmp(argv[2],str3);
		w2 = strcmp(argv[2],str4);
		w3 = strcmp(argv[2],str5);
		w4 = strcmp(argv[2],str6);
		w5 = strcmp(argv[2],str7);
		w6 = strcmp(argv[2],str8);
		w7 = strcmp(argv[2],str9);
		w8 = strcmp(argv[2],str10);
		x1 = strcmp(argv[3],str3);
		x2 = strcmp(argv[3],str4);
		x3 = strcmp(argv[3],str5);
		x4 = strcmp(argv[3],str6);
		x5 = strcmp(argv[3],str7);
		x6 = strcmp(argv[3],str8);
		x7 = strcmp(argv[3],str9);
		x8 = strcmp(argv[3],str10);
		

		if(!(u && v)){

		if(!(w1 && w2 && w3 && w4 && w5 && w6 && w7 && w8)){
			
			if(!(x1 && x2 && x3 && x4 && x5 && x6 && x7 && x8)){
			

				//if(argv[1]==str1){
					
				/*	for(count5=1;count5<=4;count5++){
						for(count4=1;count4<=8;count4++){	

								for(count3=1;count3<=4;count3++){

									for(count1=1;count1<=8;count1++){
										textcolor(RESET, argv[3], argv[2]);		
									}

									for(count2=1;count2<=8;count2++){
										textcolor(RESET, argv[2], argv[3]);
									}	

								}
							putchar('\n');
						}
		
						for(count4=1;count4<=8;count4++){	

								for(count3=1;count3<=4;count3++){

									for(count1=1;count1<=8;count1++){
										textcolor(RESET, argv[2], argv[3]);		
									}

									for(count2=1;count2<=8;count2++){
										textcolor(RESET, argv[3], argv[2]);
									}	

								}
							putchar('\n');
						}

					}
		putchar('\n');
							
			}	*/

			printf("Success"); 


			}else{
			printf("Foreground color is not available");
			}

		}else{
		printf("Background color is not available");
		}


	}else{
		printf("Requested figure is not available");
	}
	
	putchar('\n');

	}


	textcolor(RESET, WHITE, BLACK);	
	return 0;
}
	
