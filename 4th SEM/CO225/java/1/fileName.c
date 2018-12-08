/***
 * dhammika@ce.pdn.ac.lk 
 * 
 * the main function always gets its name as the first argument. 
 * So even if you do not provide any commandline argument to a 
 * C-function, the main will still get its file name. 
 */

#include <stdio.h>
int i = 1;
int main(int argc, char **argv) 
{ 
  printf("%d\n", i++);
  main(argc, argv);
  
  return 0; 

}
