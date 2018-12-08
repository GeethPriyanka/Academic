#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define RESET			0
#define BRIGHT 			1

#define BLACK 			0
#define RED			1
#define GREEN			2
#define YELLOW			3
#define BLUE			4
#define MAGENTA			5
#define CYAN			6
#define	WHITE			7	


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
	
	int u,v,w1,w2,w3,w4,w5,w6,w7,w8,x1,x2,x3,x4,x5,x6,x7,x8, bg, fg, count1,count2,count3,count4,count5;

	

	if(argc>4){
		printf("Too many arguments");
	}else if(argc<4){
		printf("Not enough arguments");
	}else if(argc=4){
		
		u = strcmp(argv[1],"checker");
		v = strcmp(argv[1],"donut");

		w1 = strcmp(argv[2],"black");
		w2 = strcmp(argv[2],"red");
		w3 = strcmp(argv[2],"green");
		w4 = strcmp(argv[2],"yellow");
		w5 = strcmp(argv[2],"blue");
		w6 = strcmp(argv[2],"magenta");
		w7 = strcmp(argv[2],"cyan");
		w8 = strcmp(argv[2],"white");

		x1 = strcmp(argv[3],"black");
		x2 = strcmp(argv[3],"red");
		x3 = strcmp(argv[3],"green");
		x4 = strcmp(argv[3],"yellow");
		x5 = strcmp(argv[3],"blue");
		x6 = strcmp(argv[3],"magenta");
		x7 = strcmp(argv[3],"cyan");
		x8 = strcmp(argv[3],"white");
		

		if(w1==0){
			bg=BLACK;
		}else if(w2==0){
			bg=RED;
		}else if(w3==0){
			bg=GREEN;
		}else if(w4==0){
			bg=YELLOW;
		}else if(w5==0){
			bg=BLUE;
		}else if(w6==0){
			bg=MAGENTA;
		}else if(w7==0){
			bg=CYAN;
		}else if(w8==0){
			bg=WHITE;
		}else{
		printf("Background color is not available\n");
		}


		if(x1==0){
			fg=BLACK;
		}else if(x2==0){
			fg=RED;
		}else if(x3==0){
			fg=GREEN;
		}else if(x4==0){
			fg=YELLOW;
		}else if(x5==0){
			fg=BLUE;
		}else if(x6==0){
			fg=MAGENTA;
		}else if(x7==0){
			fg=CYAN;
		}else if(x8==0){
			fg=WHITE;
		}else{
		printf("Foreground color is not available\n");
		}


			if(u==0){
					
					for(count5=1;count5<=4;count5++){
						for(count4=1;count4<=8;count4++){	

								for(count3=1;count3<=4;count3++){

									for(count1=1;count1<=8;count1++){
										textcolor(RESET,bg,fg);
										printf(" ");		
									}

									for(count2=1;count2<=8;count2++){
										textcolor(RESET,fg,bg);
										printf(" ");		
									}	

								}
							printf("\n");
						}
		
						for(count4=1;count4<=8;count4++){	

								for(count3=1;count3<=4;count3++){

									for(count1=1;count1<=8;count1++){
										textcolor(RESET,fg,bg);
										printf(" ");				
									}

									for(count2=1;count2<=8;count2++){
										textcolor(RESET,bg,fg);
										printf(" ");		
									}	

								}
							printf("\n");
						}

					}
//

				printf("\n");
							
			}else if(v==0){

					printf("Not constructed..!!!");
			
					/*			int count, p, z1, z2  ;
								float R, y;
								printf("Enter the radius :");
								scanf("%f",&R);
								for(y=1;y<=(3*R);y++){
									p=3*R*y-pow(y,2);
									z1=(2*R-sqrt(p));
									z2=(2*R+sqrt(p));
		
										for(count=0;count<z1;count++){
											putchar(' ');
										}
										for(count=z1;count<z2;count++){
											putchar('*');
										}
										for(count=z2;z2<count;count++){
											putchar(' ');	
										}
			
									putchar('\n');
								}
				
					*/

			}


	}else{
		printf("Requested figure is not available");
	}
	
	putchar('\n');


	textcolor(RESET, 7, 0);	
	return 0;
}
	
