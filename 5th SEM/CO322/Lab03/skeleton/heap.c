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
  IMPLEMENT_ME; 
}

void __swap(heap_t heap, int i, int j)
{
  int tmp = heap -> data[i];
  heap -> data[i] = heap -> data[j];
  heap -> data[j] = tmp;
}

int isEmpty(heap_t heap)
{
  return (heap -> next == 0);
}

heap_t create()
{
  IMPLEMENT_ME; 
}

void insert(heap_t heap, int data)
{
  IMPLEMENT_ME; 
}

int heap_remove(heap_t heap)
{
  IMPLEMENT_ME;
  
}
