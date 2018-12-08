/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package hanoi;

/**
 *
 * @author Geeth
 */
    public class Stack{            
        int top;
        int size;
        int [] arr;
        
        public Stack(int size){            //constructing a stack of given size.
            
            this.top = 0;
            this.size = size;
            this.arr = new int [size];
            
        }
        
        public boolean isEmpty(){         //check whether the stack is Empty
            return (this.top == 0);
        }

        public boolean isFull(){        //check whether the stack is full
            return (this.top == this.size);
        }
       
        public int pop(){        //taking out the top item from the stack
            if(isEmpty()){
                return Integer.MIN_VALUE;
            }
            return this.arr[(this.top--)-1];
        }
        
        public void push(int item){       //adding items to stack
            if(isFull()){
                return;
            }
            this.arr[(++this.top)-1] = item;
        }

    }