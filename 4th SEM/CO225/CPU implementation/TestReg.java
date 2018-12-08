import java.io.IOException;
class TestReg {

    public static void main(String [] args) {
	ReadWriteReg r0 = new ReadWriteReg();
	try { 
	    r0.writeReg(1);
	    System.out.println("Reading gives " + r0.readReg());
	}catch(IOException e) {
	    System.out.println("Should not be here " + e);
	}
    }
}
