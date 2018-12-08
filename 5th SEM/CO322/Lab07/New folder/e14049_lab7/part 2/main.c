#include "autocomplete.h"
#include "list.h"
#include "list.c"
#include "autocomplete.c"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>
#include <time.h>

int main(void){
  char command;
  char input[20];

  Node* root = NULL;
  clock_t start = clock();

  root = TST_seed_from_file(root, "trie.txt");

  clock_t end = clock();
  double mseconds =(double) (end - start)*1000000/CLOCKS_PER_SEC;
  printf("time taken to insert the data in micro sec:\n"); 
  printf("%f\n",mseconds);

  while (true) {


    puts("Press e to exit, or w to enter a word to complete:");
    command = getchar();
  if (command == 'w') {
      puts("Enter word to get completions for: ");
      scanf("%s", &input);
      start = clock();
      TST_get_completions(root, input);

      clock_t end = clock();
      double mseconds =(double) (end - start)*1000000/CLOCKS_PER_SEC;
      printf("time taken to retrieve the data in micro sec:\n"); 
      printf("%f\n",mseconds);



    }
    else if (command == 'e'){
      break;
    }

    // Clear input buffer
    fseek(stdin,0,SEEK_END);
  }
  TST_clear(root);
}