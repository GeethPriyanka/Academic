/* Behaviour of && and || 
 * dhammika@ce.pdn.ac.lk 
 * 
 * 
 */

class Compound {

    public static boolean callMe() { 
	System.out.println("callMe was called!!!");
	return false;
    }


    public static void main(String [] args) { 
	
	boolean flag; 

	System.out.println("==== New Test.");
	flag = true; 
	if(flag || callMe()) // callMe() will not be called 
	    System.out.println("flag or callMe true"); 
	else 
	    System.out.println("Neighther flag or callMe is true"); 

	System.out.println("==== New Test.");	
	flag = false;
	if(flag || callMe()) // calleMe() will be called
	    System.out.println("flag or callMe true"); 
	else 
	    System.out.println("Neighther flag or callMe is true"); 

	System.out.println("==== New Test.");
	flag = true; 
	if(flag && callMe()) // callMe() will be called 
	    System.out.println("flag or callMe true"); 
	else 
	    System.out.println("Neighther flag or callMe is true"); 

	System.out.println("==== New Test.");	
	flag = false;
	if(flag && callMe()) // callMe() will not be called 
	    System.out.println("flag or callMe true"); 
	else 
	    System.out.println("Neighther flag or callMe is true"); 
 
    }
}