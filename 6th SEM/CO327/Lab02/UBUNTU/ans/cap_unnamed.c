/*
E/14/403	WIMALASIRI KPGP
CO327 		Lab02				Exercise 2.1 part(d)
*/
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>

#define READ_END 0
#define WRITE_END 1

//const char banner [] = "hello there\n";

void Cap(char string[]){     
    int i;
    int x = strlen(string); 
    for (i=0;i<x;i++){
     	string[i]= toupper(string[i]);
    }
}


int main(int argc, char **argv)
{

	if(argc<2){
		fprintf(stderr,"Usage: [program_name] [String to capitalize]\n");
		return 1;
	}else{

		int pipe_simple[2];
		int pipe_capital[2];
		pid_t pid;
		char* msg = argv[1];

		//printf("%s\n",msg);
		if(pipe(pipe_simple)) 
		{
			perror("pipe_simple creation");
			return -1;
		}
		if(pipe(pipe_capital)) 
		{
			perror("pipe_capital creation");
			return -1;
		}
		pid = fork();
		if(pid < 0) 
		{
			perror("Fork");
			return -1;
		}
		
		if(pid == 0) 
		{ // child 
			printf("Start of child process\n");
			char buff[100];
			close(pipe_simple[WRITE_END]);
			sleep(3);

			printf("Waiting for parents' reply\n");
			int count = read(pipe_simple[READ_END],buff,100);
			buff[count] = '\0';

			printf("Child received :%s\n", buff);
			Cap(buff);

			printf("Child sending :%s\n", buff);
			close(pipe_capital[READ_END]);
			write(pipe_capital[WRITE_END], buff, (int)strlen(buff));
			close(pipe_capital[WRITE_END]);

			exit(EXIT_SUCCESS);
		}
		if(pid > 0) 
		{ // parent 
			printf("Start of parent process\n");
			char buff2[100];
			printf("String from the user :%s\n", msg);

			close(pipe_simple[READ_END]);
			write(pipe_simple[WRITE_END],msg,(int)strlen(msg)+1);
			close(pipe_simple[WRITE_END]);

			printf("Waiting for the reply of child..\n");

			close(pipe_capital[WRITE_END]);
			sleep(5);
			int count = read(pipe_capital[READ_END],buff2,100);
			buff2[count] = '\0';

			printf("Capitalized output :%s\n", buff2);

			exit(EXIT_SUCCESS);
		}
		return 0;
	}
}
