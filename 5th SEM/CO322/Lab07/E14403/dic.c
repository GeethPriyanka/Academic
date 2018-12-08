#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct trienode{
	struct trienode * parent;
	struct trienode * child [26];
	char letter;
        int isEnd;
}TrieNode;

TrieNode* createNode(char character);
void insertWord(char* word,int length, TrieNode* root);
int printSuggestions(char word[],TrieNode* root);
int findSuggestions(TrieNode* curr,int status);
int getIndex(char letter);


int main(int argc, char *argv[])
{
	/* code */
	if(argc!=2){
		printf("usage : [program name] [searching word]");
		return -1;
	}
        TrieNode * root;
        root = createNode('a');
        int isDone;
        isDone = 0;
        
        FILE * file;
        int c,j,k;
        j=0;
        char word [25] = "";
        file = fopen("Sample Word List.txt","r");
        if(file){           //check whether the file exist
            while((c=fgetc(file))!=EOF){        //iterate through the file until the end
                word[j] = tolower(c);           //change all to lower case
                j++;
                if(c=='\n'){                //check for word ending
                    //char word1 [j];
                    char* word1;
                    word1 = (char *)calloc(j,sizeof(char));
                    j=0;
                    while(word[j]!='\n'){
                        *(word1+j) = word[j];
                        //printf("%c",*(word1+j));
                        j++;
                    }
                    //printf("\n");
                    
                    insertWord(word1,j,root);
                    free(word1);
                    //printf("\n");
                    j=0;
                    
                    k=0;
                    while(k<25){
                        word[k] = '\n';
                        k++;
                    }
                }
            }

            
            while(!isDone){
                isDone = printSuggestions(argv[1],root);
                printf("\n");
            }
            
        }else{
            printf("File doesn't exist...!");
        }
    
	return 0;
}

TrieNode* createNode(char character){
	TrieNode * node = (TrieNode *)malloc(sizeof(TrieNode));
	node->letter = character;
        int i;
        for(i=0;i<26;i++){
            node->child[i]=NULL;
        }
        node->isEnd = 0;
	return node;
}

int printSuggestions(char word[], TrieNode* root){
    int i,dir,printStatus,isDone;
    isDone = 0;
    printStatus = 1;
    TrieNode* curr,*curr1;
    curr = root;
    i=0;
    
    while(word[i] !='\0' && printStatus){
        dir = getIndex(word[i]);
        if(curr->child[dir]==NULL){
            printStatus =0;
            //printf("\nNo matches found..!");
            break;
        }
        curr1 = curr->child[dir];
        printf("%c",curr1->letter);
        curr = curr1;
        i++;
    }
    
    isDone = findSuggestions(curr,printStatus);
    
    return isDone;

}

int findSuggestions(TrieNode* curr,int printStatus){
    TrieNode* curr1;
    int i;
    
        //printf("\ncon..");
        if(printStatus){
            if(curr->isEnd!=1){
                for(i=0;i<26;i++){
                    if(curr->child[i]!=NULL){
                        //if(curr->child[i]->isEnd!=2){
                            curr1 = curr->child[i];
                            curr = curr1;

                            printf("%c",curr->letter);
                            //printf("%d",curr->isEnd);

                            return findSuggestions(curr,printStatus);
                        //}    

                    }
                }
                return 1;
            }else{
                curr->isEnd = 0;
                return 0;
            }
        }else{
            return 1;
        }

}

void insertWord(char* word,int length, TrieNode * root){
	int i,index;
        TrieNode * curr;
        TrieNode * curr1;
	i = 0;
	index = getIndex(*(word+i));
        //printf("%d ",index);
        //printf("%d",root->isEnd);
        if((root->child[index])==NULL){        
            curr = createNode(*(word+i));
            root->child[index] = curr;
        }else{
            curr = root->child[index];
        }
        length--;
        i++;
	while(length>0){
            index = getIndex(*(word+i));
            //printf("%d ",index);
            
            if((curr->child[index])==NULL){
                curr1 = createNode(*(word+i));
                curr->child[index] = curr1;
            }else{
                curr1 = curr->child[index];
            }
            curr = curr1;
            if(length==1){
                curr->isEnd=1;
            }
            //printf("%d",curr->isEnd);
            length--;
            i++;
	}
        
}

int getIndex(char letter){
	int index;
	index = (letter-97)%26;
	return index;
}