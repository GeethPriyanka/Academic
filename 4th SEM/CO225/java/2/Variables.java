/* defining variables in a Java program 
 */

class Variables { 
    public static void main(String [] args) { 
	int a, b; 
	char grade = 'A'; // grade variable is defined and initialise 
	String hello = "Hello World", bye = "Good Bye World"; 
	String combined = hello + ", " + bye; // concatenated and assign.
	
	System.out.println(grade); // all get converted to string
	System.out.println(combined); 

	float floatNum = 102.2f; // f means convent to float
	double d = 1.2d; // by default factions are considered as double 
	System.out.println(floatNum + d); 
    }
}