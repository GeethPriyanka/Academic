/*
E/14/403	WIMALASIRI KPGP
CO327 		Lab02				Exercise 1.2 part(b)
*/


#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <string.h>

int main(int argc, char **argv)
{


	if(argc<2){
		fprintf(stderr,"Usage: [program_name] [source_file] [destination_file]\n");
		return 1;
	}else{
		int out;
		char* src_file = argv[1];
		char* tgt_file = argv[2];
		size_t size ;
		FILE * fp;
		size_t ret;

		fp = fopen( src_file, "r");
		fseek(fp, 0L, SEEK_END);	//finding the size of the file
		size = ftell(fp);
		

		out = open(src_file, O_RDONLY | O_APPEND /*| O_CREAT*/ , S_IRUSR | S_IWUSR ); //second parameter is a flag and third a mode. Find out what they do 
		
		if(out == -1)
		{
			//the exact error could be found out by looking at the variable errno. We do not cover it here 
			fprintf(stderr,"Couldn't open the source file\n");
			return 1;
		}

		printf("Reading data from the file...\n");

		char* buffer = malloc(size+1); // size of a char is 1. This buffer holds the read back value. 

		ret = read(out,buffer,size);

		if(ret == -1)
		{
			fprintf(stderr,"Error reading from file\n");
			return 1;
		}
		buffer[ret] = '\0'; // we have to null terminate the string ourselves. 
		
		//printf("The string read back is:\n %s\n",buffer);

		printf("Done with reading. Closing the file...\n");

		ret = close(out);

		if(ret == -1)
		{
			fprintf(stderr,"Error closing the file after reading.\n");
			return 1;
		}


		//Writing to the destination file

		printf("Writing data to file...\n");

		out = open(tgt_file, O_WRONLY| O_TRUNC | O_CREAT , S_IRUSR | S_IWUSR );

		ret = write(out,buffer,size);
		
		if(ret == -1)
		{
			fprintf(stderr,"Error writing to file\n");
			return 1;
		}
		printf("Done with writing.Closing the file.\n");

		ret = close(out);

		if(ret == -1)
		{
			fprintf(stderr,"Error closing the file after writing.\n");
			return 1;
		}

		
		free(buffer);

	}	

	return 0;
}
