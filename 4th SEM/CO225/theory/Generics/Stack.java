public class Stack<T> { // give an instance to T when using Stack<String>
    private int curr;
    private int max; 
    private T [] stack; 
    
    private static final int block_size = 10; 
    
    public Stack() { 
	curr = 0; 
	max  = block_size; 

	stack = (T[]) new Object[block_size];
    }


    // private functions, others need not know about this
    private boolean isFull()  { return curr == max; } 
    private void more() { 
	int newSize  = max + block_size; 
	T[] newStack = (T[]) new Object[newSize]; 
	for(int i=0; i<this.max; i++) 
	    newStack[i] = this.stack[i]; 
	
	max = newSize; 
	stack = newStack; 
    }

    // public, how the world sees me
    public  boolean isEmpty() { return curr == 0; } 
    public void push(T obj) { 
	if(isFull()) more(); 
	stack[curr++] = obj; 
    }

    public T pop() { 
	if(isEmpty()) return null; 
	return stack[--curr]; 
    }
}
	
	