import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RAM implements MemInterface {

    int cacheHits, cacheMiss;
    int sizeOfRAM;

    Map<String, Integer> memory; 

    public RAM(int sizeInMB) {
	cacheHits = cacheMiss = 0;
	sizeOfRAM = sizeInMB * 1024 * 1024;//size in bytes 
	memory = new HashMap<String, Integer>(); 
    }

    public int cacheHits() { return this.cacheHits; }
    public int cacheMisses() { return this.cacheMiss; }
    
    private boolean withinMemory(String address) throws IOException {
	int addr; 
	try { 
	    addr = Integer.parseInt(address);
	} catch(NumberFormatException e) {
	    throw new IOException("Wrong address");
	}
	    
	return (addr > 0) && (addr < this.sizeOfRAM); 
    }
    
    public int lw(String address) throws IOException {
	if(!withinMemory(address))
	    throw new IOException("bad address when loading");

	Integer val = memory.get(address);
	
	if(val == null) return 0;
	else return (int) val;
    }

    public void sw(String address, int val) throws IOException {
	if(!withinMemory(address))
	    throw new IOException("bad address when reading");

	memory.put(address, new Integer(val));
    }
}
	

    
