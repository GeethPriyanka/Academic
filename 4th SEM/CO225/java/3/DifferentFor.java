/* different ways of for loop 
 */

class DifferentFor { 
    public static void main(String [] args) { 
	int MAX = 5; 
	int i = 2; 
	for(; i < MAX; i++) // no initialization 
	    System.out.println("Value of i = " + i); 

	for(i=0; ; i++) // inifinite loop 
	    if(i == 5) break; 
	
	for(; i <= MAX;) 
	    System.out.println((++i)); 

	for(; ; ); // infinite loop 
    }
}
