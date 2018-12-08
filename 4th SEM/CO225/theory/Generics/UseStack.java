class UseStack {
    public static void main(String [] args) { 
	// need a stack of points 
	Stack <Points> pntStack = new Stack <Points> (); 
	Stack <String> strStack = new Stack <String> (); 
	Points p; 
	for(int i=0; i<20; i++) {
	    pntStack.push(new Points(i,i)); 
	    strStack.push("this is " + i);
	    //strStack.push(new Points(i,i));
	}

	while(true) { 
	    p = pntStack.pop(); 
	    if(p == null) break; 
	    p.show();
	    //System.out.println(strStack.pop()); 
	}

    }
}