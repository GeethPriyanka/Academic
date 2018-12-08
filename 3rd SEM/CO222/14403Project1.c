/* 
	This program show time and date in given color

	Author:	Wimalasiri K.P.G.P // E/14/403 
		// CO222 // Project1

*/
#include <stdio.h>
#include <time.h>
#include <string.h>
#include <unistd.h>


#define RESET		0
#define BRIGHT 		1

#define BLACK 		0
#define RED		1
#define GREEN		2
#define YELLOW		3
#define BLUE		4
#define MAGENTA		5
#define CYAN		6
#define	WHITE		7
#define NOT_REFERED	8

#define LEN 100



void textcolor(int attr, int fg, int bg);				// coloring function

void textcolor(int attr, int fg, int bg)
{	char command[13];

	/* Command is the control command to the terminal */

	/* textcolor(BRIGHT,BLACK,WHITE) will have characters printed in
	black in white background */
	sprintf(command, "%c[%d;%d;%dm", 0x1B, attr, fg + 30, bg + 40);
	printf("%s", command);
}






int arrayElement(char *buf,int index);				//to take a certain array element from time array
int* checkCharacters(int hour_1);				//to check characters given by the time array
int choose_foreground_color(char *argv2);			//to choose the color


int main(int argc, char **argv){
	int index, hour_1,x_axis,y_axis,pixel,count;
	int *hour1;
	char buf[LEN];
	time_t curtime;
 	

	int foreground=choose_foreground_color(argv[2]);

	printf("\e[?25l");  				// to hide the console cursor

while(1){
	//Getting current time of system
	curtime = time (NULL);
   
	// Displaying date and time in standard format   
	char *t_1=asctime(localtime(&curtime));		
	
	strcpy(buf,t_1);				//copying string time to a char array
	printf("\033[2J");				//clearing screen
	
		//SEC 2
		hour_1=arrayElement(buf,18);
		hour1=checkCharacters(hour_1);
		
		
		for(y_axis=1;y_axis<=5;y_axis++){
			printf("\033[%d;47H",y_axis+1);
			for(x_axis=1;x_axis<=3;x_axis++){
	
				count=(((y_axis-1)*3)+x_axis-1);
					pixel=hour1[count];
	
					if(pixel==1){
						textcolor(BRIGHT,BLACK,foreground);
						printf("  ");
						textcolor(RESET,foreground,BLACK);
					}else{
						textcolor(BRIGHT,foreground,BLACK);
						printf("  ");
						textcolor(RESET,foreground,BLACK);
					}
				
			}
			printf("\n");
			
		}
		




		//SEC 1
		hour_1=arrayElement(buf,17);
		hour1=checkCharacters(hour_1);
		
		

		for(y_axis=1;y_axis<=5;y_axis++){
			printf("\033[%d;40H",y_axis+1);
			for(x_axis=1;x_axis<=3;x_axis++){
	
				count=(((y_axis-1)*3)+x_axis-1);
					pixel=hour1[count];
	
					if(pixel==1){
						textcolor(BRIGHT,BLACK,foreground);
						printf("  ");
						textcolor(RESET,foreground,BLACK);
					}else{
						textcolor(BRIGHT,foreground,BLACK);
						printf("  ");
						textcolor(RESET,foreground,BLACK);
					}
				
			}
			
			
		}
		

		
		//DOTS
		hour_1=arrayElement(buf,16);
		hour1=checkCharacters(hour_1);
		
		for(y_axis=1;y_axis<=5;y_axis++){
			printf("\033[%d;34H",y_axis+1);
			for(x_axis=1;x_axis<=3;x_axis++){
	
				count=(((y_axis-1)*3)+x_axis-1);
					pixel=hour1[count];
	
					if(pixel==1){
						textcolor(BRIGHT,BLACK,foreground);
						printf("  ");
						textcolor(RESET,foreground,BLACK);
					}else{
						textcolor(BRIGHT,foreground,BLACK);
						printf("  ");
						textcolor(RESET,foreground,BLACK);
					}
				
			}
			printf("\n");
			
		}
		


		//MIN 2
		hour_1=arrayElement(buf,15);
		hour1=checkCharacters(hour_1);
		
		for(y_axis=1;y_axis<=5;y_axis++){
			printf("\033[%d;28H",y_axis+1);
			for(x_axis=1;x_axis<=3;x_axis++){
	
				count=(((y_axis-1)*3)+x_axis-1);
					pixel=hour1[count];
	
					if(pixel==1){
						textcolor(BRIGHT,BLACK,foreground);
						printf("  ");
						textcolor(RESET,foreground,BLACK);
					}else{
						textcolor(BRIGHT,foreground,BLACK);
						printf("  ");
						textcolor(RESET,foreground,BLACK);
					}
				
			}
			printf("\n");
			
		}
		
		
		//MIN 1
		hour_1=arrayElement(buf,14);
		hour1=checkCharacters(hour_1);
		
		for(y_axis=1;y_axis<=5;y_axis++){
			printf("\033[%d;21H",y_axis+1);
			for(x_axis=1;x_axis<=3;x_axis++){
	
				count=(((y_axis-1)*3)+x_axis-1);
					pixel=hour1[count];
	
					if(pixel==1){
						textcolor(BRIGHT,BLACK,foreground);
						printf("  ");
						textcolor(RESET,foreground,BLACK);
					}else{
						textcolor(BRIGHT,foreground,BLACK);
						printf("  ");
						textcolor(RESET,foreground,BLACK);
					}
				
			}
			printf("\n");
			
		}
		
		
		
		//DOTS
		hour_1=arrayElement(buf,13);
		hour1=checkCharacters(hour_1);
	
		for(y_axis=1;y_axis<=5;y_axis++){
			printf("\033[%d;15H",y_axis+1);
			for(x_axis=1;x_axis<=3;x_axis++){
	
				count=(((y_axis-1)*3)+x_axis-1);
					pixel=hour1[count];
	
					if(pixel==1){
						textcolor(BRIGHT,BLACK,foreground);
						printf("  ");
						textcolor(RESET,foreground,BLACK);
					}else{
						textcolor(BRIGHT,foreground,BLACK);
						printf("  ");
						textcolor(RESET,foreground,BLACK);
					}
				
			}
			printf("\n");
			
		}
		

		
		//HOUR 2
		hour_1=arrayElement(buf,12);
		hour1=checkCharacters(hour_1);

		for(y_axis=1;y_axis<=5;y_axis++){
			printf("\033[%d;9H",y_axis+1);
			for(x_axis=1;x_axis<=3;x_axis++){
	
				count=(((y_axis-1)*3)+x_axis-1);
					pixel=hour1[count];
	
					if(pixel==1){
						textcolor(BRIGHT,BLACK,foreground);
						printf("  ");
						textcolor(RESET,foreground,BLACK);
					}else{
						textcolor(BRIGHT,foreground,BLACK);
						printf("  ");
						textcolor(RESET,foreground,BLACK);
					}
				
			}
			printf("\n");
			
		}
		
		
		
		//HOUR 1
		hour_1=arrayElement(buf,11);
		hour1=checkCharacters(hour_1);
		
		for(y_axis=1;y_axis<=5;y_axis++){
			printf("\033[%d;2H",y_axis+1);
			for(x_axis=1;x_axis<=3;x_axis++){
	
				count=(((y_axis-1)*3)+x_axis-1);
					pixel=hour1[count];
	
					if(pixel==1){
						textcolor(BRIGHT,BLACK,foreground);
						printf("  ");
						textcolor(RESET,foreground,BLACK);
					}else{
						textcolor(BRIGHT,foreground,BLACK);
						printf("  ");
						textcolor(RESET,foreground,BLACK);
					}
				
			}
			printf("\n");
		
		}
		

			printf("\n");

			printf("\033[20C");			// centering cursor to print date
		
		//printing date
		char a[50];
		time_t x = time (0);
		strftime (a, 50, "%Y-%m-%d", localtime (&x));
		printf ("%s\n", a);


sleep(1);		// delaying the while loop by a second
	
}
	
	return 0;
}

int arrayElement(char *buf, int index){
	int hour1;
	hour1=buf[index];
	return hour1;
}

int* checkCharacters(int hour_1){
	

	
		if(hour_1==48){
			static int pixal_array[15]={1,1,1,1,0,1,1,0,1,1,0,1,1,1,1};
			return pixal_array;
		}else if(hour_1==49){
			static int pixal_array[15]={0,0,1,0,0,1,0,0,1,0,0,1,0,0,1};
			return pixal_array;
		}else if(hour_1==50){
			static int pixal_array[15]={1,1,1,0,0,1,1,1,1,1,0,0,1,1,1};
			return pixal_array;
		}else if(hour_1==51){
			static int pixal_array[15]={1,1,1,0,0,1,1,1,1,0,0,1,1,1,1};
			return pixal_array;
		}else if(hour_1==52){
			static int pixal_array[15]={1,0,1,1,0,1,1,1,1,0,0,1,0,0,1};
			return pixal_array;
		}else if(hour_1==53){
			static int pixal_array[15]={1,1,1,1,0,0,1,1,1,0,0,1,1,1,1};
			return pixal_array;
		}else if(hour_1==54){
			static int pixal_array[15]={1,1,1,1,0,0,1,1,1,1,0,1,1,1,1};
			return pixal_array;
		}else if(hour_1==55){
			static int pixal_array[15]={1,1,1,0,0,1,0,0,1,0,0,1,0,0,1};
			return pixal_array;
		}else if(hour_1==56){
			static int pixal_array[15]={1,1,1,1,0,1,1,1,1,1,0,1,1,1,1};
			return pixal_array;
		}else if(hour_1==57){
			static int pixal_array[15]={1,1,1,1,0,1,1,1,1,0,0,1,1,1,1};
			return pixal_array;
		}else if(hour_1==58){
			static int pixal_array[15]={0,0,0,0,1,0,0,0,0,0,1,0,0,0,0};
			return pixal_array;
		}else{
			printf("error");
			return 0;
		}
}


int choose_foreground_color(char *argv3){
		
int foreground,foreground_black,foreground_blue,foreground_cyan,foreground_green,foreground_magenta,foreground_red,foreground_white,foreground_yellow;
		
		//check whether which color has been entered as the second argument
		
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
