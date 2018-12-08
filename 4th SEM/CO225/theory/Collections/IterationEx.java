import java.util.*; // for collections 

// sample which uses sets.
// see http://docs.oracle.com/javase/7/docs/api/java/util/Set.html

class IterationEx {
    public static void main(String [] args) { 
	int [] data = {11, 123, 3, 14, 23, 3, 412, 3, 2};
	Set<Integer> set = new LinkedHashSet<Integer>(); 
	for(int i=0; i<data.length; i++)  set.add(data[i]); 

	Iterator<Integer> it = set.iterator(); 
	while(it.hasNext()) 
	    System.out.println(it.next());
    }
}
	    