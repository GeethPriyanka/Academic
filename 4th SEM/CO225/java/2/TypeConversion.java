/* Domnstrate how division changes type 
 */ 


class TypeConversion { 
    public static void main(String [] args) { 
	
	int a = 8; 
	int b = 3; 
	float c = 3.0f;// or float c = 3f;
	double d = 3d; // or double d = 3.0; 
	System.out.println("int (10) /int (3) \t= " + (a/b)); 
	System.out.println("int (10) /float (3)\t= " + (a/c)); 
	System.out.println("int (10) /double (3)\t= " + (a/d)); 

    }
}


