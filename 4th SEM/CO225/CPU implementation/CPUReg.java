import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.io.IOException;

public class CPUReg {

    Map<String, RegBase> regFile;
    static String [] regNames = { "R0", "R1", "R2", "R3",
				  "R4", "R5", "R6", "R7" }; 
    public CPUReg() {
	regFile = new HashMap<String, RegBase>();

	// R0 is readOnly
	regFile.put("R0", new ReadOnlyReg()); 
	for(int i = 1; // R0 is already in. Start from next
	    i < regNames.length; i++) {
	    regFile.put(regNames[i], new ReadWriteReg());
	}
    }

    public int readReg(String regName) throws IOException {

	RegBase reg = regFile.get(regName);
	if(reg == null) throw new IOException("Cannot find register");
	return reg.readReg();
    }

    public void writeReg(String regName, int value) throws IOException {
	RegBase reg = regFile.get(regName);
	if(reg == null) throw new IOException("Cannot find register");
	reg.writeReg(value);
    }
}

    

    
