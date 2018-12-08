/* Tower of Hanoi implementation in C
 * Usage: hanoi <from> <to> <via> <disks>
 * example: hanoi 'A' 'B' 'C' 5 
 */
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

#define USAGE "Usage:\nhanoi <from:char> <to:char> <via:char> <disks:int>\n"

/* recursive implementation */
void move(char from, char to, char via, unsigned int disks);

  
int main(int argc, char **argv)
{
  /* check if the commandline arguments are correct */
  if(argc != 5) exit(!printf("Invalid number of arguments\n" USAGE));  
  if(!isalpha(*argv[1]) || !isalpha(*argv[2]) || !isalpha(*argv[3])
     || !atoi(argv[4]))
    exit(!printf("Invalid type of arguments\n" USAGE));

  char from = *argv[1];
  char to   = *argv[2];  
  char via  = *argv[3];
  unsigned int disks = atoi(argv[4]);
  printf("Move %d disks from %c to %c via %c\n", disks, from, to, via);
  
  move(from, to, via, disks);
  return EXIT_SUCCESS;
}

void move(char from, char to, char via, unsigned int disks)
{
  if(disks) {
    move(from, via, to, disks-1);
    printf("Move disks %d from %c to %c\n", disks, from, to);
    move(via, to, from, disks-1);
  }
}