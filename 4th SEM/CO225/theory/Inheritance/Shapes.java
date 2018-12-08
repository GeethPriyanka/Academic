public class Shapes { 

    private String colour; 
    public Shapes(String colour) { 
	this.colour = colour; 
    }

    public void show() { 
	System.out.println(get_colour()+ "  " +  
			   get_type() + " which has area of " + 
			   get_area()); 
    } 


    public String get_colour() { return this.colour; }

    public String get_type() { return "Unknown"; } // not the best way 
    public float get_area() { return 0f; } /* not the best way. 
					    * Interface is better */
}