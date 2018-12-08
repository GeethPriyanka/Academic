
/*
This program sorts words in decending order in a given text file according to the word length. Source file name should be entered in command line after the program name argument.

Author:		Wimalasiri KPGP
Reg. NO.:	E/14/403
Subject:	CO222

*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int main(int argc ,char **argv){

	FILE * text;


	char b[10]="./";
	char a;
	char c[20];
	strcat(b,argv[1]);	//to concatenate command line argument(file name) with "./"

	text = fopen(b, "r");
					
	typedef struct node{
		char word[20];
		int word_length;
		struct node * next;
	} node_t;		//defining the basic structure of linked list

	node_t * head = NULL;
	node_t * current = NULL;	
	
	head = (node_t *)malloc(sizeof(node_t));
		
	head->word_length=0;
	head->next=NULL;
	
	while(!feof(text)){			
		
		int count1=0,count2=0;
		current = (node_t *)malloc(sizeof(node_t));
		

		fscanf(text,"%c",&a);
		c[0]=a;
		count1=1;
		while(!isspace((int)a)){
			
			fscanf(text,"%c",&a);
			c[count1]=a;
			count1++;
		}

		while(!isspace((int)c[count2])){	//assigning the words in the text into the linked list
			current->word[count2]=c[count2];
			count2++;
		}

		
		current->word_length=count1-1;  	//assigning the word length of words into the linked list
		current->next=head;
		head =current;

		
	}

	node_t * current1 = head;
	node_t * current2 = head;
	node_t * largest = current1;
	
	while(current2->next != NULL){		//traversing through the linked list

		current2=current2->next;	//switching to the next node
		current1 = head;

		while(current1->next != NULL){	//traversing through the linked list
			

			if(current1->word_length>=largest->word_length)
				largest = current1;	//gaining the largest word node
			
			current1=current1->next;	//switching to the next node
		}
		if(largest->word_length!=0)
		printf("%s\n",largest->word);		//printing the largest word
		largest->word_length=0;			//stopping the particular word printing again

		
	}




	return 0;
}
