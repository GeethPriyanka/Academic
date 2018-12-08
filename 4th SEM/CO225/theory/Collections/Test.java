import java.util.ArrayList;
import java.util.HashMap;

class Test { 
    
    public static void main(String [] args) { 
	HashMap<String, Student> e11 = new HashMap<String, Student>(); 

	Student a = new Student("Saman Jinadasa", "E/11/890", "889123234V", 
				"2011", 3.05); 
	e11.put("E/11/890", a); 

	a = new Student("Sam Liyanage", "E/11/554", "90091223232V", "2011", 1.2);
	e11.put("E/11/554", a); 

	e11.get("E/11/554").display();
    }

	    
} // end Test class
 