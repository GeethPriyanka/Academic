/* Demostrate the scope of a variable 
 * 
 * dhammika@ce.pdn.ac.lk 
 */ 

class Scope { 
    static int i = 0; 
    static int MAX = 10; // by convension constants are capitalised 
    public static void main(String [] args) { 

	int i = 10; // mask the static int i, defined above 
	System.out.println("i = " + i ); 

	for(int j=0; j < MAX; j++) // no MAX in function. Take static one
	    System.out.println("j = " + j); 

	// j = 10; //will not work. j's scope is within the for loop

    }
}