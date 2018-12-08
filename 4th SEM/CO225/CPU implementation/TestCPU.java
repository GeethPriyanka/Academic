import java.io.IOException;

class TestCPU {

    static String [] prog = {
	"LI R1 10",
	"LI R2 20",
	"ADD R3 R1 R2",
	"MUL R3 R3 R2"
            };
    
    public static void main(String [] args)  {
	try {
	    
	    CPUReg regFile = new CPUReg();
	    Controller cnt = new Controller();
	    
	    for(int i=0; i < prog.length; i++) {
		String [] cmd = prog[i].split(" ");
		cnt.executeInstruction(cmd, regFile);
	    }
	    
	    System.out.println("R3 = " +
			       regFile.readReg("R3"));
	} catch(IOException e) {
	    System.out.println(e);
	}
    }
}

		      
