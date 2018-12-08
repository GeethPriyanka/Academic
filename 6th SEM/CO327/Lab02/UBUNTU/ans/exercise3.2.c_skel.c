/*
E/14/403	WIMALASIRI KPGP
CO327 		Lab02				Exercise 3.2 part(c)
*/
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <stdlib.h>
#include <sys/wait.h>

/**
 * Executes the command "cat fixtures | grep <search_term> | cut -b 1-9".
 */
#define INPUTFILE "fixtures"
#define READ_END 0
#define WRITE_END 1

void die(const char*);

int main(int argc, char **argv)
{
	/*int status;
	int i;*/
	int pipe1[2];
	int pipe2[2]; // Second pipe
	int pid;

	if (argc < 2)
	{
		printf("%s: missing operand\n", argv[0]);
		printf("Usage: %s <search_term in %s>\n", argv[0], INPUTFILE);
		exit(EXIT_FAILURE);
	}


	// arguments for commands
	char *cat_args[] = {"cat", INPUTFILE, NULL};
	char *grep_args[] = {"grep", "-i", argv[1], NULL};
	char *cut_args[] = {"cut", "-b", "1-9", NULL};


	// make 2 pipes (cat to grep and grep to cut); each has 2 fds

	if (pipe(pipe1) == -1)
		die("pipe1()");

	if (pipe(pipe2) == -1)
		die("pipe2()");

	pid = fork();
	if(pid == (pid_t)(-1))
		die("fork()");

	if (pid == 0)
	{
		// child gets here and handles "grep <search_term> | cut -b 1-9"

		printf("Begining of the child process..\n");

		if(pipe(pipe1) == -1) 
			die("pipe1()");

		int pid2 = fork();

		if (pid2 < 0)
			die("fork2()");

		if (pid2 == 0){

			// child handles grep <seach_term>

			printf("Begining of the child of child...\n");

			// replace standard output with output part of pipe
			if(dup2(pipe1[WRITE_END],1) == -1)
				die("dup2()");

			// close unused input half of pipe
			close(pipe1[READ_END]);

			// execute cat
			if(execvp("cat", cat_args) == -1)
				die("execvp()");

			exit(EXIT_SUCCESS);

		}else{

			// Parent to handle cut -b 1-9

			printf("Begining of the new parent and waiting for child of child..\n");
			// wait till child finishes
			wait(NULL);

			printf("Waiting of new parent is stopped.\n");

			// replace standard input with input part of pipe
			if(dup2(pipe1[READ_END], 0) == -1)
				die("dup2()");

			if (dup2(pipe2[WRITE_END], 1) == -1)
				die("dup2()");

			// close unused half of pipe
			close(pipe1[WRITE_END]);
			close(pipe2[READ_END]);

			// execute grep
			if(execvp("grep", grep_args) == -1)
				die("execvp()");

			exit(EXIT_SUCCESS);	
		}
		exit(EXIT_SUCCESS);

	}else{
		// parent gets here and handles "cat INPUTFILE"

		printf("Old parent started and waiting for child....\n");

		wait(NULL);

		printf("Waiting of old parent is stopped.\n");

		// replace standard input with input part of pipe
		if(dup2(pipe2[READ_END], 0) == -1)
			die("dup2()");

		// close unused half of pipe
		close(pipe2[WRITE_END]);

		printf("OUTPUT\n");
		// execute grep
		if(execvp("cut", cut_args) == -1)
			die("execvp()");

		exit(EXIT_SUCCESS);
	}
}

/* A better way to Die (exit) */
void die(const char *msg) {
	perror(msg);
	exit(EXIT_FAILURE);
}