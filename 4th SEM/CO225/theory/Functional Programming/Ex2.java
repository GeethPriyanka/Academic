public class Ex2 { 
    static int i;
    final static int max = 3;
    public static void main(String [] args) {
	for(i=0; i < max; i++) { 
	    Thread t = new Thread(new Runnable() { 
		    int id = i; 
		    public void run() {
			for(int i=0; i < max; i++) 
			    System.out.println(i + " from thread " + id);
		    }
		});
	    t.start();
	}
    }
} 