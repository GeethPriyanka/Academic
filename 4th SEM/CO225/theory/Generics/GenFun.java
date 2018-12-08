public class GenFun { 
    static <T> void swap(T[] array, int i, int j) { 
	T tmp = array[i]; 
	array[i] = array[j];
	array[j] = tmp;
    }

    public static <T extends Comparable<T>> 
			     void sort(T [] array) { // bubble sort 
	for(int i=0; i < array.length; i++) 
	    for(int j=array.length - 1; j > i; j--)
		if(array[j].compareTo(array[j-1]) <= 0) 
		    swap(array, j, j-1);
    }

    public static <T> void print(T [] a) { 
	for(int i=0; i < a.length; i++) 
	    System.out.print(a[i] + " "); 
	System.out.println(); 
    }

    public static void main(String [] args) { 
	Integer [] a = {1, 23, 3, 5, 1, 32, 4};
	String [] s = {"Zoo", "Engineering", "CO222", "CO255", "Computer"};
	sort(s); 
	print(s);
    }
	
}
			
		    