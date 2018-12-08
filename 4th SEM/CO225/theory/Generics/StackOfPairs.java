public class StackOfPairs{ 

    public static void main(String [] args) { 

	Stack <Pair<String, Points>> stack = 
	    new Stack <Pair<String, Points>>(); 

	String str = "This is point ";
	Pair<String, Points> tuple; 

	for(int i=0; i<20; i++) { 
	    str += i; 
	    tuple = new Pair<String, Points>(str, new Points(i,i));
	    stack.push(tuple); 
	}

	while(true) { 
	    tuple = stack.pop(); 
	    if(tuple == null) break; 
	    tuple.getValue().show();
	    System.out.println(tuple.getKey());
	}
    }
}

	
	    