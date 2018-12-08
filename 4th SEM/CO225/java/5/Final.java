import java.io.*; // for IO channels 
class Final {

    public static void main(String [] args) { 
	
	String fileName = null; 

	try { 
	    fileName = args[0];
	} catch(IndexOutOfBoundsException ex) { 
	    fileName = "Final.java"; // default file to read
	} finally { 
	    Cat.show(fileName);
	}
    }

    public static void mainBad(String [] args) { 
	
	String fileName = null; 

	fileName = args[0];	
	Cat.show(fileName);	
    }

    public static void mainTake2(String [] args) { 
	
	String fileName = null; 
	fileName = args[0];
	
	try { 
	    Cat.show_throws(fileName);
	} catch(IOException e) {
	    System.out.println("Something bad");
	}
	
    }
}