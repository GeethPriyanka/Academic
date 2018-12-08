import java.io.IOException;
class TestRegFile {
    public static void main(String [] args)
	throws IOException {
	CPUReg registers = new CPUReg();

	System.out.println("R0 = " + registers.readReg("R0"));

	System.out.println("Write 5 to R1");
	registers.writeReg("R1", 5);
	System.out.println("R1 = " + registers.readReg("R1"));

	try {
	    registers.writeReg("R0", 5);
	} catch(IOException e) {
	    System.out.println("Got the exception " + e);
	    return; 
	}
	System.out.println("****** Bad test failed");
    }
}
	    
