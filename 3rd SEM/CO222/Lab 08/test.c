#include <stdio.h>

int main(int argc,char **argv) {

   FILE *fp;
   char buff[20];
    fp = fopen("/paragraph.txt", "r");
   int count=0;
   while(! feof(fp)){
   
   fscanf(fp,"%s",buff);
   printf("%s",buff);
   
   count++;
	}
	
	printf("\n");
	return 0;

}

