#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/wait.h>


int main(char argc,char **argv){
	char str[50];
	
	int pid;

	while(1){
		pid  =  fork();
		wait(NULL);
		if(pid  <  0){
			perror("fork");
			exit(1);
		}
		if(pid  ==  0){
		
			printf("Enter the command :");
			scanf("%[^\n]", str);
			
			execlp("/bin/sh","/bin/sh", "-c", str, (char *)NULL);
			puts("Program has terminated");
		
		}
			
	}
	return 0;

}
