class Sum { 
    
    public static void main(String [] args) { 
	int MAX = 11, sum, i;
	
	for(i = 1, sum = 0; i < MAX; i++) // sum of 1 to 10 numbers 
	    sum += i; 

	System.out.println("Sum = " + sum); 

	for(i = 1, sum = 0; i < MAX;  sum +=i, i++);

	System.out.println("Sum = " + sum); 
    }
}