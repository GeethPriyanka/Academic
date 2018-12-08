public final class Rectangle extends Shapes { 
    /* You cannot extend Rectangle since it is final */

    private float a, b; 

    public Rectangle(String colour, float a, float b) { 
	super(colour); /* call the constructor from superclass
			* has to be done first */ 
	this.a = a; 
	this.b = b; 
    }

    @Override 
    public String get_type() { return "Rectangle"; } 
    @Override 
    public float get_area() { 
	return a * b; 
    }
}
	