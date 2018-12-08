/* command line arguments in C

*/

#include <stdio.h>

int main(int argc, char** argv){
	int count = 0;

	printf("the number of arguments = %d\n", argc);

	while(count < argc){
		printf("arg #%d = %s\n", count+1, argv[count]);
		count = count + 1;
	}

	return 0;
}

