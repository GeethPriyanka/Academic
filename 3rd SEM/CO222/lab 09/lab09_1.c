#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int main(int argc ,char **argv){

	FILE * text;


	char b[10]="./";
	char a;
	char c[20];
	strcat(b,argv[1]);

	text = fopen(b, "r");
					
	typedef struct node{
		char word[20];
		int word_length;
		struct node * next;
	} node_t;

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

		while(!isspace((int)c[count2])){
			current->word[count2]=c[count2];
			count2++;
		}



		
		
		
		current->word_length=count1-1;
		current->next=head;
		head =current;

		
	}

	node_t * current1 = head;

	while(current1->next != NULL){
		printf("%s\n",current1->word);
		printf("%d\n",current1->word_length);
		current1=current1->next;
	}
	

	return 0;
}
