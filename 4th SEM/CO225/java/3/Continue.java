/* Continue in java 
 */

class Continue { 
    
    public static void main(String [] args) { 
	
	int i, MAX=5; 
	
	for(i=0; i < MAX; i++) {
	    if(i % 2 != 0) continue; 
	    System.out.printf("Value of i = %d\n", i);
	}

	i = 0; 
	while(i > 0) { 
	    if(i % 2 != 0 ) continue; 
	    System.out.printf("Value of i = %d\n", i);
	    i++;
	}
	/* above for and while loops are identical */

	
	for(i=0; i < MAX; i++) {
	    if(i % 2 != 0) break; 
	    System.out.printf("Value of i = %d\n", i);
	}
	
	i = 0; 
	while(i > 0) { 
	    if(i % 2 != 0 ) break; 
	    System.out.printf("Value of i = %d\n", i);
	    i++;
	}   
    }
}
	    