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


/*
int main(char argc,char **argv){
	execl("/bin/ls",  "-l",  argv[1],  NULL);
	puts("Program  ls has terminated");
}
*/
/*
int main(void){

	int pid;
	pid  =  fork();
	wait(NULL);
	if(pid  <  0){
		perror("fork");
		exit(1);
	}
	if(pid  ==  0)
		puts("This  is the  child  process");
	else
		puts("This  is the  parent  process");
	return 0;
}
*/
/*int main(void)
{
	int i,j;
	for(i=0;i<3;i++)
	fork();
	j =wait(NULL);
	printf("%d\n", j);

	return 0;
}
*/
