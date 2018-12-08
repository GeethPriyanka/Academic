#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

int main(){
	FILE *fp;
	
	fp = fopen("./paragraph.txt", "r");
	char a;
	fscanf(fp,"%c",&a);
	 while(! feof(fp)){
		while(!isspace((int)a)){
				
			printf("%c",a);
			fscanf(fp,"%c",&a);
		}

		if((int)a==32){
				
				printf(" ");
				
		}else if((int)a==10){
				printf("\n");
		}


	fscanf(fp,"%c",&a);
		
	}
	printf("\n");
	return 0;
}
