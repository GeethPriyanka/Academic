/**********************************************************
 *                      E/xx/xxx                          *
 **********************************************************/
import java.io.*;
import java.awt.*; /* java abstract window toolkit */
import java.awt.event.*; 
import javax.swing.*;
import java.util.*;;
import java.awt.image.BufferedImage ;
import javax.imageio.ImageIO;

import java.awt.geom.Line2D;

public class Main extends JPanel { 

    /* title for the panel */
    public static final String TITLE   = "TEST IMAGE";

    /* how big should my panel be */
    public static final int IMG_WIDTH  = 600; 
    public static final int IMG_HEIGHT = 600; 

    /* where to map the panel to complex plane 
     * Basically min and max for real and complex axis
     * You can change these numbers and see what you get
     */

    public static final double minRe = -2.00;
    public static final double maxRe = 2;
    public static final double minIm = -2.0;
    public static final double maxIm = 2.0;
    
   /* 
    * following array keeps track of colour for each pixel 
    */
    public static Color [][] image;
    public static String s;
    public static Complex a;
    public static final double XFAC = (maxRe - minRe) / IMG_WIDTH;
    public static final double YFAC = (maxIm - minIm) / IMG_HEIGHT;

   // public static HashMap<String, Patterns> patern = new HashMap<String, Patterns>();
/*
    public static void init_shel(){
    		patern.clear();

    		patern.put("M", new Mandelbrot());
            patern.put("J", new Julia());


    }
*/
    


    public Main(String s,Complex z) { 
	/* set the size of the frame */
		setPreferredSize(new Dimension(IMG_WIDTH, IMG_HEIGHT)); 
		image = new Color[IMG_WIDTH][IMG_HEIGHT];
		generateImage(s,z);
    }

   

    public void paintComponent(Graphics g) { 
	/* call the paintComponent from super class
	 * sets up the window 
	 */
			super.paintComponent(g); 
			paintImage((Graphics2D)g); 
    }

    public static void printPoint(Graphics2D frame, 
				  Color c, Points p) { 
			frame.setColor(c); 
		frame.draw(new Line2D.Double(p.x, p.y, p.x, p.y));
    }
    

    public static void generateImage(String s, Complex z) { 
		

            if(s.equals("M")){
                for(int x=0; x < IMG_WIDTH; x++) { 
                    for(int y=0; y < IMG_HEIGHT; y++) { 
                    Points  p   = new Points(x, y);
                    Complex c   = mapToComplexPlane(p); 
                    image[x][y] = Mandelbrot.mandelgetColor(c,z);

                    }
                }
            } else if(s.equals("J")){
                for(int x=0; x < IMG_WIDTH; x++) { 
                    for(int y=0; y < IMG_HEIGHT; y++) { 
                        Points  p   = new Points(x, y);
                        Complex c   = mapToComplexPlane(p); 
                        
                        image[x][y] = Julia.juliagetColor(c,z);

                    }
                }
            }else{

                System.out.println("No patern found");
            }
			
		    
		
		System.out.println("Image Generated!");
    }
   
    public static void paintImage(Graphics2D frame) { 
		for(int x=0; x < IMG_WIDTH; x++) { 
		    for(int y=0; y < IMG_HEIGHT; y++) { 
			printPoint(frame, image[x][y], new Points(x,y));
		    }
		}
		System.out.println("Image Printed!");
    }    

    public static Complex mapToComplexPlane(Points p) { 
		return new Complex(p.x * XFAC + minRe, 
				   p.y * YFAC + minIm);
    }

     public static void formFrame(String s, Complex z) throws IOException {

            JFrame frame = new JFrame(TITLE); 

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

            frame.setContentPane(new Main(s,z)); 

            frame.pack(); 

            frame.setLocationRelativeTo(null); 

            frame.setVisible(true); 

            final BufferedImage image = new BufferedImage(
               frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics gr = image.getGraphics();
            frame.printAll(gr);
            gr.dispose();
            try {
              Robot robot = new Robot();
               final Rectangle rect = frame.getBounds();
               final BufferedImage image1 = robot.createScreenCapture(rect);

                ImageIO.write(image1, "PNG", new File("WindowCapture.png"));

            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
             
          

    }


        public static void main(String [] args) throws IOException { 
        		// Scanner scanIn = new Scanner(System.in);
        			//init_shel();
        	     System.out.println(" If you want Mandelbrot set press(M) , Julia set press(J) ?");
	        	 String s;

			       Scanner scanIn = new Scanner(System.in);
			       s= scanIn.nextLine();
                   
			     //  scanIn.close();            
			      // System.out.println(s);
			       				
	   			 

   				 if(s.equals("M")){

   				 	System.out.println("patern Madelbrot set");
   				 //	patern("M");
                    Complex b=new Complex(0,0);
   				 	formFrame("M",b);
   				 }else if(s.equals("J")){
   				 	System.out.println("patern julia set");
   				 //	patern("J");
                   
                    System.out.println(" Input tne complex constant as double x, double y?");
                      String k;
                   //   Scanner scanner = new Scanner(new InputStreamReader(System.in));
                     k= scanIn.nextLine();
                     scanIn.close();
                     System.out.println(k);
                    String[] twonum = k.replaceAll(",", " ").split(" ");

                   // System.out.println(twonum[0] +"and" +twonum[1]);
                    Complex a = new Complex(Double.parseDouble(twonum[0]),Double.parseDouble(twonum[1]));
   				 	formFrame("J",a);
   				 }else{
   				 	System.out.println("fail");

   				 }

        }


   

} /* end of class */

    
