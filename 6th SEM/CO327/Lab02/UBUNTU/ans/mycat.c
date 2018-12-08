/*
E/14/403	WIMALASIRI KPGP
CO327 		Lab02				Exercise 1.2 part(a)
*/


#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <string.h>

int main()
{
	int out;
	size_t size ;
	FILE * fp;

	fp = fopen( "Ex01.txt", "r");
	fseek(fp, 0L, SEEK_END);	//finding the size of the file
	size = ftell(fp);

	printf("Opening the file to read the string written...\n");
	
	out = open("Ex01.txt", O_RDONLY| O_APPEND | O_CREAT, S_IRUSR | S_IWUSR );
	
	if(out == -1)
	{
		fprintf(stderr,"Couldn't open the file\n");
		return 1;
	} 

	printf("Reading data back from the file...\n");

	char* buffer = malloc(size+1); // size of a char is 1. This buffer holds the read back value. 

	size_t ret = read(out,buffer,size);

	//printf("%ld",ret);

	if(ret == -1)
	{
		fprintf(stderr,"Error reading from file\n");
		return 1;
	}
	buffer[ret] = '\0'; // we have to null terminate the string ourselves. 
	
	write(STDOUT_FILENO, buffer, size);

	//printf("The string read back is:\n %s\n",buffer);
	// In case there was something already written in the file, the text read back might not be the same as what was written 
	
	printf("Done with reading. Closing the file...\n");
	
	free(buffer);

	ret = close(out);

	if(ret == -1)
	{
		fprintf(stderr,"Error closing the file after reading.\n");
		return 1;
	}

	return 0;
}
