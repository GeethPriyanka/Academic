
/* my array list: an array that behaves like a list 
 * E/14/403
 */
import java.lang.*;

public class MySet<T/* Can we have any T */> { 

    int nextItem; 
    int currentCapacity; 
    T[] data; // DO NOT CHANGE

    private static int defaultSizeToCreate = 10; // how many elements to create 

    public MySet(int elements) { 
	this.nextItem = 0; 
	this.defaultSizeToCreate = elements; 
	this.currentCapacity = elements; 

	this.data = (T[]) new Object[this.defaultSizeToCreate]; 
    }

    public MySet() { 
	this(defaultSizeToCreate); 
    }

    public boolean isEmpty() { return this.nextItem == 0; } 
    public boolean isFull() { return nextItem==currentCapacity; } 

    public boolean add(T item) { 

    	try{
			data[nextItem] = null; // DO NOT CHANGE 
		}catch(ArrayIndexOutOfBoundsException ex){
				more();
		}

	/* if there is any element delete it 
	 * then add the new element. 
	 * How do you handle when the array is full: 
	 * crate a new array with currentCapacity+defaultSizeToCreate, 
	 * copy the old conents into that
	 * Accessing array when full might be a problem
	 */

	/* Add the item to the array if the item is not there */
			//System.Out.Println(nextItem);
		
		if(data[nextItem]!= null){
			data[nextItem]=null;
		}

		for(int i=0; i<nextItem; i++){
			if(item.equals(data[i])){
				return false;
			}
		}

		data[nextItem++] = item;

	return true; 

    }


    public T remove() { 
	/* remove the first element in the array 
	 * and copy the rest front. 
	 * FIFO structure. 
	 * If the ArrayList is empty return null
	 */
	/* Option 1: */
	if(isEmpty()) return null; 
	return data[--nextItem]; 
	
	/* Option 2: 
	if(!isEmpty()) { 
	    return data[--nextItem]; 
	}
	return null;
	*/
	// which option is better? why? 
    }

	private void more(){
		int newSize = currentCapacity+defaultSizeToCreate;
		T[] newData = (T[]) new Object[newSize];

		for(int i=0; i<this.currentCapacity; i++){
			newData[i]=this.data[i];
		}
		this.currentCapacity = newSize;
		this.data = newData;
	}

}
	 

	