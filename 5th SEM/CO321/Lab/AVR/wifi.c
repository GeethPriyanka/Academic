#include <stdio.h>
#include <string.h>
#define SIZE 800   // size of string buffer

int main(){
	
	FILE * pFile;
   char buffer[SIZE];
   char out[10][20];
	
	char cmd0[100] = "netsh wlan show profile > tmp.txt";
	system(cmd0);
	
	pFile = fopen("tmp.txt" , "r");
   if (pFile == NULL) {
      perror("Error opening file");
   } else {
      while (!feof(pFile)) {
         if (fgets(buffer, SIZE, pFile) == NULL) break;
         fputs (buffer , stdout);
      }
      fclose(pFile);
   }
   int i=0,count=0,j=0;
   //printf("%d",strlen(buffer));
   for(i=0;i<800;i++){
	   printf("%c\n",buffer[i]);
	   if(buffer[i]=='A' && buffer[i+1]=='l' && buffer[i+2]=='l'){
		   while(buffer[i]!=':'){
			i++;
		   }
		   i++;
		   while(buffer[i]!='\n') {
			out[count][j] = buffer[i];
			i++;
			j++;
		   }
		   out[count][j+1] = '\0';
		   count++;
		   j=0;
		   printf("%s",out[0]);
	   }
   }
	
	return 0;
}