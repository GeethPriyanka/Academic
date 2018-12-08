//This is a program which can print checker board or donut in given radius and in given color
//Author : Wimalasiri KPGP / E14403 / CO222 Lab05

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define RESET			0
#define BRIGHT 			1

#define BLACK 			0
#define RED				1
#define GREEN			2
#define YELLOW			3
#define BLUE			4
#define MAGENTA			5
#define CYAN			6
#define	WHITE			7	
#define NOT_REFERED		8

void textcolor(int attr, int fg, int bg);

void textcolor(int attr, int fg, int bg)
{	char command[13];

	/* Command is the control command to the terminal */

	/* textcolor(BRIGHT,BLACK,WHITE) will have characters printed in
	black in white background */
	sprintf(command, "%c[%d;%d;%dm", 0x1B, attr, fg + 30, bg + 40);
	printf("%s", command);
}

int choose_background_color(char *argv2);																		//declaring the function to choose background color
int choose_foreground_color(char *argv3);																		//declaring the function to choose foreground color
void choose_task(char *argv1,int foreground,int background);													//declaring the function to choose the task
void print_checker(int foreground, int background, int count1, int count2,int count3, int count4,int count5);	//declaring the function to print checker
void print_donut(int radius, int foreground, int background);													//declaring the function to print donut

int main(int argc, char **argv){
	
	int count1,count2,count3,count4,count5,donut,checker,background,foreground,radius;

	if(argc>4){
		printf("Too many arguments\n");							//check whether the number of arguments entered are too much
	}else if(argc<4){
		printf("Not enough arguments\n");						//check whether the number of arguments entered are not enough
	}else{
		background=choose_background_color(argv[2]);			//taking the background color by second argument
		foreground=choose_foreground_color(argv[3]);			//taking the background color by third argument
			
		if(background==NOT_REFERED || foreground==NOT_REFERED){
			return 0;											//ending the program if background or foreground color is not correct
		}else{
			choose_task(argv[1],foreground,background);			//deciding whether to print donut or checker and printing
		}
	}
	
		textcolor(RESET,WHITE,BLACK);	
	return 0;
}

	void print_donut(int radius, int foreground, int background){
		
			int y_axis, x_axis;

						for(x_axis=-radius;x_axis<=radius;x_axis++){																			//horizontal range
							for(y_axis=-radius;y_axis<=radius;y_axis++){																		//vertical range
								if(((x_axis*x_axis+y_axis*y_axis)<=radius*radius)&&((x_axis*x_axis+y_axis*y_axis)>=(radius/2)*(radius/2))){
									textcolor(RESET,foreground,background);
									printf(" ");
								}else{
									textcolor(RESET,background,foreground);
									printf(" ");
								}	
							}
							printf("\n");
						}
	}

	void print_checker(int foreground, int background, int count1, int count2,int count3, int count4,int count5){
		for(count5=1;count5<=4;count5++){
						for(count4=1;count4<=8;count4++){	

								for(count3=1;count3<=4;count3++){

									for(count1=1;count1<=8;count1++){
										textcolor(RESET,background,foreground);
										printf(" ");		
									}

									for(count2=1;count2<=8;count2++){
										textcolor(RESET,foreground,background);
										printf(" ");		
									}	

								}
							printf("\n");
						}
		
						for(count4=1;count4<=8;count4++){	

								for(count3=1;count3<=4;count3++){

									for(count1=1;count1<=8;count1++){
										textcolor(RESET,foreground,background);
										printf(" ");				
									}

									for(count2=1;count2<=8;count2++){
										textcolor(RESET,background,foreground);
										printf(" ");		
									}	

								}
							printf("\n");
						}

					}
					printf("\n");
	}
	
	void choose_task(char *argv1,int foreground, int background){
		
		int radius,count1,count2,count3,count4,count5,checker,donut;
		
		checker = strcmp(argv1,"checker");										//check whether the first argument is "checker"
		donut = strcmp(argv1,"donut");											//check whether the first argument is "donut"
		
			if(checker==0){
						print_checker(foreground,background,count1,count2,count3,count4,count5);
							
			}else if(donut==0){
						scanf("%d",&radius);									//taking the radius as an input from the user
						print_donut(radius,background,foreground);
						
			}else{
				printf("Requested figure is not available\n");
			}
	}
	
	int choose_background_color(char *argv2){
		
		int foreground,background,background_black,background_red,background_green,background_yellow,background_blue,background_magenta,background_cyan,background_white;
		
		//check whether which color has been entered as the second argument
		 
		background_black = strcmp(argv2,"black");				
		background_red = strcmp(argv2,"red");
		background_green = strcmp(argv2,"green");
		background_yellow = strcmp(argv2,"yellow");
		background_blue = strcmp(argv2,"blue");
		background_magenta = strcmp(argv2,"magenta");
		background_cyan = strcmp(argv2,"cyan");
		background_white = strcmp(argv2,"white");

		
		if(background_black==0){
			background=BLACK;
			return background;
		}else if(background_red==0){
			background=RED;
			return background;
		}else if(background_green==0){
			background=GREEN;
			return background;
		}else if(background_yellow==0){
			background=YELLOW;
			return background;
		}else if(background_blue==0){
			background=BLUE;
			return background;
		}else if(background_magenta==0){
			background=MAGENTA;
			return background;
		}else if(background_cyan==0){
			background=CYAN;
			return background;
		}else if(background_white==0){
			background=WHITE;
			return background;
		}else{
			printf("Background color is not available\n");
			background=NOT_REFERED;
		return background ;
		}
		
	}
	
	int choose_foreground_color(char *argv3){
		
		int foreground,background,foreground_black,foreground_blue,foreground_cyan,foreground_green,foreground_magenta,foreground_red,foreground_white,foreground_yellow;
		
		//check whether which color has been entered as the third argument
		
		foreground_black = strcmp(argv3,"black");
		foreground_red = strcmp(argv3,"red");
		foreground_green = strcmp(argv3,"green");
		foreground_yellow = strcmp(argv3,"yellow");
		foreground_blue = strcmp(argv3,"blue");
		foreground_magenta = strcmp(argv3,"magenta");
		foreground_cyan = strcmp(argv3,"cyan");
		foreground_white = strcmp(argv3,"white");
		
		
		if(foreground_black==0){
			foreground=BLACK;
			return foreground;
		}else if(foreground_red==0){
			foreground=RED;
			return foreground;
		}else if(foreground_green==0){
			foreground=GREEN;
			return foreground;
		}else if(foreground_yellow==0){
			foreground=YELLOW;
			return foreground;
		}else if(foreground_blue==0){
			foreground=BLUE;
			return foreground;
		}else if(foreground_magenta==0){
			foreground=MAGENTA;
			return foreground;
		}else if(foreground_cyan==0){
			foreground=CYAN;
			return foreground;
		}else if(foreground_white==0){
			foreground=WHITE;
			return foreground;
		}else{
			printf("Foreground color is not available\n");
			foreground=NOT_REFERED;
		return foreground;
		}
	}