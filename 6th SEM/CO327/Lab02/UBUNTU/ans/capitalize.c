/*
E/14/403	WIMALASIRI KPGP
CO327 		Lab02				Exercise 2.1 part(d)
*/
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

#define READ_END 0
#define WRITE_END 1

//const char banner [] = "hello there\n";

int main(int argc, char **argv)
{

	if(argc<2){
		fprintf(stderr,"Usage: [program_name] [String to capitalize]\n");
		return 1;
	}else{

		int pipe_send[2];
		int pipe_recv[2];
		pid_t pid;
		char* msg = argv[2];

		if(pipe(pipe_send) && pipe(pipe_recv)) 
		{
			perror("Pipe creation");
			return -1;
		}
		pid = fork();
		if(pid < 0) 
		{
			perror("Fork");
			return -1;
		}
		if(pid > 0) 
		{ /* parent */
			int i;
			close(pipe_send[READ_END]);
			for(i=0; i<10; i++) 
			{
				printf("Parent Writing [%d]...\n",i);
				write(pipe_send[WRITE_END], banner, strlen(banner));
				sleep(1);
			}
			exit(EXIT_SUCCESS);
		}
		if(pid == 0) 
		{ /* child */
			char buff[128];
			int count;
			close(pipe_send[WRITE_END]);
			while((count = read(pipe_send[READ_END], buff, 128)) > 0) {
				write(STDOUT_FILENO, &buff, count);
				sleep(2);
			}
		}
		return 0;
	}
}
