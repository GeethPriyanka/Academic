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
	a=0;
	int count2,count3;
	fscanf(fp,"%c",&a);
		 while(! feof(fp)){
			count2=1;
			count3=1;

			while(count2<=argv1){

				while(!isspace((int)a)){
				
					count3++;
					
					fscanf(fp,"%c",&a);
					
				}

				if((int)a==32){
				
						printf(" ");
						count2++;
				
				}else if((int)a==10 || count2+count3>argv1){
						count2=1;
						printf("\n");
				}else{

				while(!isspace((int)a)){
				
					count2++;
					printf("%c",a);
					fscanf(fp,"%c",&a);
					
				}

				}

			}
			printf("\n");
			
			fscanf(fp,"%c",&a);
		
		}
	fclose(fp);

	}

	printf("\n");
	return 0;

}

