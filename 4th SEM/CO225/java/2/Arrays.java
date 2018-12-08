/* Examples of defining arrays 
 * dhammika@ce.pdn.ac.lk 
 */


class Arrays { 

    public static void main(String [] args) { // arrays of Strings called args

	/* Note: 
	 * 0. Use of loop
	 * 1. Passing arrays as arguments 
	 * 2. lenght of an array 
	 * 3. defining arrays 
	 */
	for(int i=0; i < args.length; i++) 
	    System.out.printf("%s\n", args[i]); 

	int [] a = {1, 2, 3, 4, 5}; 
	for(int i=0; i < a.length; i++) 
	    System.out.printf("a[%d] = %d\n",i, a[i]); 

	int [] b = new int[10]; // similar to b = malloc(sizeof(int) * 10) 
	// new will create a new array object 
	for(int i=0; i < b.length; i++)  b[i] = b.length - i; 
	for(int i=0; i < b.length; i++) 
	    System.out.printf("b[%d] = %d\n",i, b[i]); 
	
    }
}
	
	