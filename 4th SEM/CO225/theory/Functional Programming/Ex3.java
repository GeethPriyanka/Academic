import java.util.Function;

public class Ex3 { 
    interface Foo { 
	public int doSomething(int a, int b); 
    }

    public static void map(int [] a, Foo x) { 
	for(int i=0; i < a.length; i++) 
	    a[i] = x.doSomething(a[i], 1);
    }

    public static void main(String [] args) { 
	int a[] = {1, 2, 3, 4, 5, 6};
	System.out.println(a);
	Foo add = (x, y) -> x + y; 
	map(a, add);
	System.out.println(a);
    }
}
