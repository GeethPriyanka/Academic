#include <stdio.h>
int main(void)
{
	int pid;
	int pid1;
	int pid2;
	pid = fork();

	if (pid < 0){
		perror("fork");
		exit(1);
	}
	if (pid == 0){
	puts("This is the child process");
	pid1 = getppid();
	printf("%d\n", pid1);
	
	}else{
	puts("This is the parent process");
	pid2 = getpid();
	printf("%d\n", pid2);
	}
	return 0;
}