#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>

#define MAX_SIZE 1024 

void die(const char *msg);

int main(int argc, char **argv) 
{ 	

	if(argc<2){
		fprintf(stderr,"Usage: [program_name] [String to capitalize]\n");
		return 1;
	}else{

		int fd, fd2; 
		char* fifo = "/tmp/fifo"; 
		char* fifo2 = "/tmp/fifo2";

		char buff[MAX_SIZE]; 
	    
		mkfifo(fifo, 0666);
		mkfifo(fifo2, 0666);

		printf("Sending to reader: %s\n", argv[1]);
		fd = open(fifo, O_WRONLY);
		write(fd, argv[1], strlen(argv[1])); 
	    close(fd); 

		fd2 = open(fifo2, O_RDONLY);
	    read(fd2, buff, MAX_SIZE); 
	    printf("Capitalized String: %s\n", buff); 
	    close(fd2); 

		unlink(fifo);
		unlink(fifo2);

    return 0; 
    }
}

/* A better way to Die (exit) */
void die(const char *msg) {
	perror(msg);
	exit(EXIT_FAILURE);
}