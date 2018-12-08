import java.util.*; // for collections 

// sample use of for-each

class ForEachSample {
    public static void main(String [] args) { 
	int [] data = {11, 123, 3, 14, 23, 3, 412, 3, 2};
	Set<Integer> set = new LinkedHashSet<Integer>(); 
	for(int i=0; i<data.length; i++)  set.add(data[i]); 

	for(Object o: set) 
	    System.out.println(o);
    }
}
	    