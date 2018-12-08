public class Triangle extends Shapes { 

    private float b, h; 

    public Triangle(String colour, float b, float h) { 
	super(colour); /* call the constructor from superclass
			* has to be done first */ 
	this.b = b; 
	this.h = h; 
    }

    @Override 
    public String get_type() { return "Triangle "; } 

    @Override 
    public float get_area() { 
	return 0.5f * b * h; 
    }

}
