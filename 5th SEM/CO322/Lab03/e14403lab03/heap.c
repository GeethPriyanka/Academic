//E/14/403
//KPGP WIMALASIRI
//CO322 LAB03	Min heap implementing

#include "heap.h"
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

#define IMPLEMENT_ME							\
  printf("you need to implement %s function in %s\n",__func__, __FILE__);	\
  exit(-1);

/**
 * Note: typically, in C functions/variables that starts with 
 * __ are local and should not be used unless you really know what you
 * are doing. For example __start 
 */
int __isFull(heap_t heap)
{
  return (heap -> next == heap -> curr_size);
}

void __resize_heap(heap_t heap)
{

  //IMPLEMENT_ME;
  int newSize = heap -> curr_size + INCREASE_BY;		//new size --> current size is increased by 100
  int i;
  int * dataTmp;
  dataTmp = (int *)malloc (newSize *sizeof(int));		//allocating space for new size

  for(i=0;i<(heap -> curr_size);i++){
  	dataTmp[i] = heap -> data[i];						//copying old values from heap->data to new array
  }

  heap -> data = dataTmp;								//assigning new array to the heap
  heap -> curr_size = newSize; 							//assigning new size to the heap->curr_size
	  
}

void __swap(heap_t heap, int i, int j)					//swapping data for given indexes  
{
  int tmp = heap -> data[i];
  heap -> data[i] = heap -> data[j];
  heap -> data[j] = tmp;
}

int isEmpty(heap_t heap)
{
  return (heap -> next == 0);							//check whether the heap->next is zero
}

heap_t create()
{
  //IMPLEMENT_ME; 
	heap_t heap = (heap_t *)malloc (sizeof(heap_t));	//allocating space for heap structure
	heap -> data = (int *)malloc (SIZE *sizeof(int));	//allocating space for data array
	heap -> next = 0;
	heap -> curr_size = SIZE;							//initializing the size of heap array
	return heap;

}

void insert(heap_t heap, int data)
{
  //IMPLEMENT_ME;

	if(__isFull(heap)){									//check whether the heap array is full
		__resize_heap(heap);
	}

	int childIndex = heap->next;
	int parentIndex = (int)((childIndex-1)/2);
	

	if(parentIndex>0){

		heap->data[childIndex] = data;

		while((childIndex>0)&&(heap->data[childIndex] < heap->data[parentIndex])){	//popping up finally added element to the top if it is smaller 
			__swap(heap,childIndex, parentIndex);
			childIndex = parentIndex;
			parentIndex = (int)((childIndex -1)/2);
		}

	}else if(childIndex==0){
		heap->data[childIndex] = data;					//first element adding
	}else{
		heap->data[childIndex] = data;					//second level element adding
		if(heap->data[childIndex] < heap->data[parentIndex]){
			__swap(heap,childIndex,parentIndex);
		}
	}


	heap->next++;										//incrementing the array index
   
}

int heap_remove(heap_t heap)
{
  //IMPLEMENT_ME;

	int pop = heap->data[0];							//taking the top element(smallest element)
	int finalIndex = heap->next-1;						//last element index of array
	int parentIndex = 0;
	int childIndex = 0;
	int leftChildIndex;
	int rightChildIndex;

	heap->data[0] = heap->data[finalIndex];				//taking bottom element to the top

	heap->next--;										//decrementing the array index

	while(1){
		leftChildIndex = 2*(parentIndex)+1;
		rightChildIndex = 2*(parentIndex)+2;


		if((heap->next <= rightChildIndex)||(heap->next <= leftChildIndex)){	
			break;										//check whether the right and left child indexes are within the constraints
		}else if(heap->next > rightChildIndex){			//check whether there is a right child

			if(heap->data[rightChildIndex] < heap->data[leftChildIndex]){		//finding the minimum out of left and right children
				childIndex = rightChildIndex;
			}else{
				childIndex = leftChildIndex;
			}

		}else{
			childIndex = leftChildIndex;
		}
		
		if(heap->data[parentIndex] > heap->data[childIndex]){			//popping up the minimimum by swapping		
		  __swap(heap,parentIndex,childIndex);
		  parentIndex = childIndex;
		}else{
			break;
		}	
	}




	return pop;
}
