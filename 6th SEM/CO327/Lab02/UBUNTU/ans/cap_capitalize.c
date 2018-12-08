#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>

#define MAX_SIZE 1024 

void die(const char *msg);

int main() 
{ 
	int fd, fd2; 
	char* fifo = "/tmp/fifo"; 
	char* fifo2 = "/tmp/fifo2";

	printf("Waiting for the input..\n");

	char *tr_args[] = {"tr","[:lower:]","[:upper:]", NULL};

	mkfifo(fifo,0666);
	mkfifo(fifo2,0666);

	fd = open(fifo, O_RDONLY);
	fd2 = open(fifo2, O_WRONLY);

	if (dup2(fd, 0) == -1)
		die("dup2()");

	if (dup2(fd2, 1) == -1)
		die("dup2()");

	if(execvp("tr", tr_args) == -1)
		die("execvp()");

	close(fd);
	close(fd2);
	exit(EXIT_SUCCESS);

    return 0; 
}

/* A better way to Die (exit) */
void die(const char *msg) {
	perror(msg);
	exit(EXIT_FAILURE);
}