#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>
#include <time.h>

#define INDEX_TO_CHAR(c) ((int)c + (int)'a')

typedef struct trienode{

    struct trienode *children [26];
    bool  isEnd;

} TrieNode;

TrieNode * createNode(){
	 TrieNode *tNode = NULL;
 
    tNode = (TrieNode *)malloc(sizeof(TrieNode));
 
    if (tNode)
    {
        int i;
        tNode->isEnd = false; 
 
        for (i = 0; i < 26; i++)
            tNode->children[i] = NULL;
    }
 
    return tNode;
}



void insertToTrie(TrieNode *root ,const char *word){
	int len = strlen(word);
	int index,i;
	TrieNode *tr = root;

 	for(i=0; i<len;i++){
		index = word[i] - 'a';
        if (!tr->children[index])
            tr->children[index] =  createNode();
 
        tr = tr->children[index];
		
	}

	tr -> isEnd =true;

}

char suggestW[25]={};
char tmp[25]={};
int size = 0;
void printSuggestions(TrieNode *t){

	 int i=0;
    if(t->isEnd) {
        tmp[size] = '\0';
        printf("Suggestion : %s%s\n", suggestW,tmp);
    }
    for(i=0;i<26;i++){
        if(t->children[i]){
            tmp[size] = (char) INDEX_TO_CHAR(i);
            size++;
            printSuggestions(t->children[i]);
            size--;
        }
    }

}

bool findSuggestions(TrieNode *root,const  char *word)
{
  
    int i,count=0;
    int len = strlen(word);
    int index;
    TrieNode *t = root;
 
    for (i = 0; i < len; i++){
    
        index = word[i]- 'a';
 
        if (!t->children[index])
            return false;

        suggestW[count] = INDEX_TO_CHAR(index);
        count++;
 
        t = t->children[index];
    }

    suggestW[count] = '\0';
    printSuggestions(t);

    return (t != NULL && t->isEnd);
}

int main (){

	FILE * pFile;
	char word[25];
    pFile = fopen("trie.txt","r");

	TrieNode *root =  createNode();
    
    clock_t start = clock();
    while(!feof(pFile)){
        fscanf(pFile,"%s",word);
        int j = 0;
        while(word[j]){
            if(isupper(word[j])) word[j] = tolower(word[j]);
            j++;
        }

        
        insertToTrie(root, word); // inset to the trie word by word
        
    }
    clock_t end = clock();
    double mseconds =(double) (end - start)*1000000/CLOCKS_PER_SEC;
    printf("time taken to store the data in micro sec:\n");
    printf("%f\n",mseconds);

	fclose(pFile);

	char input [50]={};

	while(1){

		printf("search a word >>");
		scanf("%s",input);
		printf(" ");
        start = clock();
		findSuggestions(root ,input);
        end = clock();
        mseconds =(double) (end - start)*1000000/CLOCKS_PER_SEC;
        printf("time taken to retrieve the data in micro sec:\n"); 
        printf("%f\n",mseconds);
		printf(" ");
		


	}

return 0;
}
