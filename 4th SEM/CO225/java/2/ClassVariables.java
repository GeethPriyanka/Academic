/* demostrate the use of a class vairable 
 * a class varaible is static and can be accessed from 
 * static and non-static methods provided you have access permission. 
 * 
 */
import java.lang.*; 

class ClassVariables { 

    static int i = 0; 
    static int j = 0; 
    int k; // non-static variable 
    public static void main(String [] args) { 
	int j = 9; // this will mask the value of (static) j 
	System.out.println("i = " + i); 
	// static i can be refered from static function  	
	System.out.println("j = " + j); 	
	// here, j referes to local variable j. 
	// k cannot be referenced since it is non-static 
    }
}
