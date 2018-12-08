#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

int main(int argc,char **argv) {

	FILE *fp;
   	char b[50]="./";
	char a;
	int count,count1;


	strcat(b,argv[2]);
	
    	fp = fopen(b, "r");
   	
	
	
	int max_count = 1;
	
	 while(! feof(fp)){
		fscanf(fp,"%c",&a);
		count=1;
		while(!isspace((int)a)){
			
			fscanf(fp,"%c",&a);
				if(count>max_count){
					max_count=count;			
				}
			count++;
		}

	}
	fclose(fp);
	int argv1=atoi(argv[1]);
	if(argv1<max_count){
		printf("Word length must be less than screen width");		

	}else{
	fp = fopen(b, "r");
	char a=0;
	int count2;
	fscanf(fp,"%c",&a);
		 while(! feof(fp)){
			
				while(!isspace((int)a)){
				
					printf("%c",a);
					fscanf(fp,"%c",&a);
					
				}

				if((int)a==32){
				
						printf(" ");
				
				}else if((int)a==10 ){
						printf("\n");
				}
			
			fscanf(fp,"%c",&a);
		
		}
	fclose(fp);

	}

	printf("\n");
	return 0;

}

