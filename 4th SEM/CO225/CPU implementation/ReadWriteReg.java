import java.io.IOException;

class ReadWriteReg extends RegBase {

    public ReadWriteReg() {
	value = 0;
    }

    public int readReg() throws IOException {
	return value;
    }

    public void writeReg(int value) throws IOException {
	this.value = value;
    }

}
