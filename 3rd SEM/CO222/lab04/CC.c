#include <stdio.h>
#include <stdlib.h>
#include <string.h>

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
	int backcolor,forcolor;
if(argc<4){
printf("Not enough arguments");
}
else if(argc==4){
	if(strcmp(argv[2],"black")==0){
		backcolor=BLACK;
		
	}else if(strcmp(argv[2],"red")==0){
		backcolor=RED;
	}else if(strcmp(argv[2],"green")==0){
		backcolor=GREEN;
	}else if(strcmp(argv[2],"yellow")==0){
		backcolor=YELLOW;
	}else if(strcmp(argv[2],"blue")==0){
		backcolor=BLUE;
	}else if(strcmp(argv[2],"cyan")==0){
		backcolor=CYAN;
	}else if(strcmp(argv[2],"white")==0){
		backcolor=WHITE;
	}else{
		printf("Background color is not available\n");
		return 0;
	}
	
	if(strcmp(argv[3],"black")==0){
		forcolor=BLACK;
		
	}else if(strcmp(argv[3],"red")==0){
		forcolor=RED;
	}else if(strcmp(argv[3],"green")==0){
		forcolor=GREEN;
	}else if(strcmp(argv[3],"yellow")==0){
		forcolor=YELLOW;
	}else if(strcmp(argv[3],"blue")==0){
		forcolor=BLUE;
	}else if(strcmp(argv[3],"cyan")==0){
		forcolor=CYAN;
	}else if(strcmp(argv[3],"white")==0){
		forcolor=WHITE;
	}else{
		printf("Foreground color is not available\n");
		return 0;
	}

	if(strcmp(argv[1],"checker")==0){
	
	int a,b,c,d,e,f,g,h,i,j;
	for(h=1;h<=4;h++){
	for(g=1;g<=8;g++){
	for(a=1;a<=4;a++){
		for(b=1;b<=8;b++){
			textcolor(RESET, backcolor, forcolor);
			printf(" ");
		}
			for(c=1;c<=8;c++){
				textcolor(RESET, forcolor, backcolor);
			printf(" ");
		}
		
	}
	printf("\n");
	}
	
		for(i=1;i<=8;i++){
		for(d=1;d<=4;d++){
		for(e=1;e<=8;e++){
			textcolor(RESET, forcolor, backcolor);
			printf(" ");
		}
			for(f=1;f<=8;f++){
				textcolor(RESET, backcolor, forcolor);
			printf(" ");
		}
		
	}
		for(j=1;j<=8;j++){
		textcolor(RESET, forcolor, backcolor);
		printf(" ");
		}
		
	printf("\n");
	
		}
		
	}
	
	
	
	
	printf("\n");
	}
	
	
	
	else{
	printf("Requested figure is not available\n");
	}
	}else{
	printf("Too many arguments\n");
	}


	//textcolor(RESET, WHITE, BLACK);	
	return 0;
	
	
}
