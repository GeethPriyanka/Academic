public class Ex1 {

    interface SaySomething { 
	public void greet(); 
    }

    public static void main(String [] args) { 
	class SayHi implements SaySomething { 
	    String whatToSay = "Hi world";
	    // no constructor. Default will be used
	    public void greet() { 
		System.out.println(whatToSay);
	    }
	}// end of class definition 
	
	SaySomething hi = new SayHi(); 
	
	SaySomething bye = new SaySomething() {
		// class is defined here.
		// cannot be used in another place 
		String whatToSay = "bye world";
		public void greet() { 
		    System.out.println(whatToSay);
		}
	    };// end of class 
	    
	hi.greet();
	bye.greet();
    }// end of main
} //end of class 