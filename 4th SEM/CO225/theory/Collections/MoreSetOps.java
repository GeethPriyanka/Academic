import java.util.*; // for collections 

// sample which uses sets.
// see http://docs.oracle.com/javase/7/docs/api/java/util/Set.html

class MoreSetOps {
    public static void main(String [] args) { 
	String [] d1 = {"one", "two", "three", "four"};
	String [] d2 = {"one", "two", "five", "six", "seven"};

	Set<String> s1 = new LinkedHashSet<String>(Arrays.asList(d1)); 
	Set<String> s2 = new LinkedHashSet<String>(Arrays.asList(d2));
	Set<String> tmp = new LinkedHashSet<String>();//empty set 

	System.out.println("Before: " + tmp);
	tmp.addAll(s1); // add all elements of s1
	System.out.println("After addAll(s1): " + tmp);

	System.out.println("\nBefore: " + tmp);
	tmp.addAll(s2); // add all elements of s2
	System.out.println("After addAll(s2): " + tmp);

	System.out.println("\nBefore: " + tmp);
	tmp.retainAll(s2); // retainAll of s2 in tmp (union of tmp s2)
	System.out.println("After retainAll(s2): " + tmp);

	System.out.println("\nBefore: " + tmp);
	tmp.removeAll(s1); // removeAll of s1 in tmp (diff tmp s1)
	System.out.println("After removeAll(s1): " + tmp);	

    }
}
	    
	
	