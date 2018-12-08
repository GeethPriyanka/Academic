/* conditional executions 
 */

class Conditional { 
    
    public static void main(String [] args) { 
	int year = 1996; 

	if(year > 1900) // also can be in the 21st century 
	    System.out.println("May be born in the 20th Century");
	else 
	    System.out.println("Not born in the 20th Century");


	if(year > 2017) System.out.println("You do not exists");


	if(year > 1900 && year < 2000) 
	    System.out.println("Born in the 20th Century");


	String result = year > 1900 && year < 2000 ? 
	    "Born in the 20th Century" : "Unknown"; 
	System.out.println(result);

    }
}
	