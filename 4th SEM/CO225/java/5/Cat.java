/* Show the use of exceptions 
 * dhammika@ce.pdn.ac.lk 
 */ 
import java.io.*; // for IO channels 

public class Cat { 

    // display the content of the given file. 
    // should not complie 
    /*
    public static void show_no_catch(String fileName) { 
	FileReader readDesc = null; 
	BufferedReader reader = null; 
	String line = null; 

	readDesc = new FileReader(fileName); 	

	// Buffered readers are faster and works with large files 
	// Wrap the readDesc with a buffered reader 

	reader = new BufferedReader(readDesc); 
	
	while((line = reader.readLine()) != null) 
	    System.out.println(line);     

	reader.close(); 
	readDesc.close(); 	
    }
    */

    // display the content of the given file. 
    public static void show_different_try_catch(String fileName) { 
	FileReader readDesc = null; 
	BufferedReader reader = null; 
	String line = null; 

	try {
	    readDesc = new FileReader(fileName); 
	} catch(FileNotFoundException ex) { 
	    System.out.println("File " + fileName + " cannot be openned"); 
	}

	// Buffered readers are faster and works with large files 
	// Wrap the readDesc with a buffered reader 

	reader = new BufferedReader(readDesc); 
	
	try { 
	    while((line = reader.readLine()) != null) 
		System.out.println(line);     

	    reader.close(); 
	    readDesc.close(); 
	} catch(IOException ex) { 
	    System.out.println("Some IO Exception"); 
	}
	
    }

    public static void show_throws(String fileName) 
	throws IOException, FileNotFoundException { 
	FileReader readDesc = null; 
	BufferedReader reader = null; 
	String line = null; 

	readDesc = new FileReader(fileName); 	
	
	// Buffered readers are faster and works with large files 
	// Wrap the readDesc with a buffered reader 
	
	reader = new BufferedReader(readDesc); 	
	
	while((line = reader.readLine()) != null) 
	    System.out.println(line);     
	    
	reader.close(); 
	readDesc.close();     
    }


    /* better implementation */
    public static void show(String fileName) { 
	FileReader readDesc = null; 
	BufferedReader reader = null; 
	String line = null; 

	try {
	    readDesc = new FileReader(fileName); 	
	    
	    // Buffered readers are faster and works with large files 
	    // Wrap the readDesc with a buffered reader 

	    reader = new BufferedReader(readDesc); 	

	    while((line = reader.readLine()) != null) 
		System.out.println(line);     
	    
	    reader.close(); 
	    readDesc.close(); 
	} catch(FileNotFoundException e2) { // more specific ones first 
	    System.out.println("File " + fileName + " cannot be openned"); 
	} catch(IOException e1) { 
	    System.out.println("Some IO Exception"); 
	}
    }


}

	