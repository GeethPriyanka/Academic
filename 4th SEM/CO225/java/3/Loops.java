/* syntax of loops 
 * 1. for loops 
 * 2. while loops 
 * 3. do-while loops
 *
 * dhammika@ce.pdn.ac.lk 
 */ 

class Loops { 
    public static void main(String [] args) { 

	int MAX = 5; 

	for(int i=0; i < MAX; i++) 
	    System.out.println("Value of i = " + i); 
	
	int j = 0; 
	while(++j < MAX) // How many times will you print? 
	    System.out.printf("j = %d\n", j); 

	boolean flag = false; 
	do  
	    System.out.println("We will always execute once!"); 
	while(flag); 

    }
}

