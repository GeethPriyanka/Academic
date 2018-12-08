/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package lab04co322;
/**************************************************
 * Simple sorting algorithms 
 * Modified by E/14/403
 **************************************************/
import java.util.Random;

class CompareSorting { 
    
    static int count = 0;           //count to check whether how many swaps done
    
    static void bubble_sort(int [] data) { 
 
        for(int j=0;j<data.length;j++){
            count=0;                    // for each start of round make count=0
            for(int i=1;i<data.length;i++){
                if(data[i]<data[i-1]){      // checking whether the two considered items are sorted
                    data = swap(i-1,i,data);
                    count++;                // count incremented as swap called
                }
            }
            if(count==0)        // no swaps done
                break;          // stop sorting
        }
        
    }

        
    
    static void selection_sort(int [] data) { 
    
        int maxIndex=0;
        int i;
        
        for(int j=0; j<data.length; j++){                   // j is counting backwards as the sorted items are kept in the end of the array
            i=data.length-1-j;                          // i is the counter which iterates through unsorted items
            maxIndex = getMaxIndex(data,0,i);           // getting the index of maximum item in the unsorted list
            data = swap(data.length-1-j,maxIndex,data); // swapping the maximum item with next sorted item
        }
        
        
    
    }

    static void insertion_sort(int [] data) { 
        
        for(int i=0; i<data.length-1; i++){         // iterating through the whole list
            if(data[i]>data[i+1]){              // check whether the next item is less than the current
                int tmp = data[i+1];            // copying next item to a tmp
                for(int j=i;j>=0;j--){          // iterating through the sorted items
                    if(tmp<data[j]){        
                        data[j+1] = data[j];    // shifting items by one step
                        data[j] = tmp;          // inserting the considered value
                    }else{
                        break;              // if the item is kept in the right place break the loop
                    }
                }
            }
        }
        
    }


    // Helper functions 

    static int [] generate_data(int sizeOfData) { 
	/* create an array of sizeOfData and 
	 * populate with random integers betweem 0-1000
	 */

	int [] tmp = new int[sizeOfData];
	Random rand = new Random();
	for(int i=0; i < sizeOfData; i++)
	    tmp[i] = rand.nextInt(2*sizeOfData);
	return tmp; 
    }

    static int [] duplicate_array(int [] data) { 
	/* create a duplicate array of the given 
	 * useful when sending the same array to different 
	 * algorithms.
	 */
	int [] tmp = new int[data.length];
	for(int i=0; i< data.length; i++)
	    tmp[i] = data[i];
	
	return tmp; 
    }

    static void show(int [] data) {
	System.out.printf("\n");
	for(int i=0; i < data.length; i++)
	    System.out.printf("%d %c", data[i],
			      i == (data.length - 1) ? ' ' : ',');
	System.out.printf("\n");
    }
    
    static void postCondition(int [] data) { 
	/* if sorted, for any i data[i] > data[i-1]
	 * Need to run this with java -ea CompareSorting
	 */
	int i; 
	for(i=1; i < data.length; i++) 
	    if(data[i] > data[i-1]) break; 

	assert i == data.length : "Sorting algorithm used is broken";
    }
    
    private static int [] swap(int index2, int index1, int[] data) {
        int tmp;
        tmp = data[index2];
        data[index2]=data[index1];
        data[index1]= tmp;
        return data;
     
    }

     
     
    private static int getMax(int[] data) {         // getting the maximum item from the given array
        int max=0;
        for(int i=0;i<data.length;i++){
            if(max<data[i]){
                max =data[i];
            }
        }
        return max;
    }
    
    private static int getMaxIndex(int[] data, int from, int to) {      // getting the maximum item's index from the given array
        int max=0;
        int maxIndex=0;
        for(int i=from;i<=to;i++){
            if(max<data[i]){
                max =data[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String [] ar) {
        
	    int [] t = generate_data(30);
        int [] t1 = duplicate_array(t);
        int [] t2 = duplicate_array(t);

        show(t);
        System.out.println();
        System.out.print("Bubble Sort");
        long timeBubble1 = System.nanoTime();
        bubble_sort(t);
        long timeBubble2 = System.nanoTime();
        long timeBubble = timeBubble2 - timeBubble1;
    	show(t);
        System.out.println();
    	postCondition(t); 
        
        System.out.println();
        System.out.print("Selection Sort");
        long timeSelection1 = System.nanoTime();
        selection_sort(t1);
        long timeSelection2 = System.nanoTime();
        long timeSelection = timeSelection2 - timeSelection1;
        show(t1);
        System.out.println();
        postCondition(t1); 
        
        System.out.println();
        System.out.print("Insertion Sort");
        long timeInsertion1 = System.nanoTime();
        insertion_sort(t2);
        long timeInsertion2 = System.nanoTime();
        long timeInsertion = timeInsertion2 - timeInsertion1;
        show(t2);
        System.out.println();
        postCondition(t2); 

        System.out.println("Bubble sort\t----> "+timeBubble+" ns");
        System.out.println("Selection sort\t----> "+timeSelection+" ns");
        System.out.println("Insertion sort\t----> "+timeInsertion+" ns");
    }


   
}

	   
