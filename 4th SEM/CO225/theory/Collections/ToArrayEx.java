import java.util.*; 

class ToArrayEx { 
    public static void main(String [] args) { 
	String [] d1 = {"six", "seven", "one", "two", "five"};

	// asList converts the array into a list which is again a collection
	LinkedList<String>l = new LinkedList<String>(Arrays.asList(d1));
	System.out.println(l); 

	// collections can be created from other collections 
	// here l is a collection of (list of strnigs). We make a hashSet of it
	Set<String>s1 = new HashSet<String>(l);
	System.out.println(s1); 

	Object [] str = s1.toArray();
	for(int i=0; i < str.length; i++)
	    System.out.println("From Array: " + str[i]);

    }
}