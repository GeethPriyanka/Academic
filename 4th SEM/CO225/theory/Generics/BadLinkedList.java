/* 
 * Motivation for generics. 
 */
public class BadLinkedList { 
    int nextItem; 
    int max; 
    Object [] data; 
    private static final int blockSize = 10; 

    public BadLinkedList() {
	this.nextItem = 0; 
	this.max = blockSize; 
	data = new Object[blockSize];//Object are link void *
    }

    private void more() { 

	int size = this.max + blockSize; // add blockSize more elements 
	Object [] newData = new Object[size]; 
	for(int i=0; i<this.max; i++) 
	      newData[i] = this.data[i]; 

	this.data = newData; 
	this.max = size; 
    }

    public boolean isEmpty() { return this.nextItem == 0; }
    public boolean isFull()  { return this.nextItem == this.max; } 

    public void add(Object o) { 
	if(isFull()) more(); 	
	this.data[this.nextItem++] = o; 
    }

    public Object remove() { 
	if(isEmpty()) return null; 	
	return this.data[--this.nextItem]; 
    }
}

