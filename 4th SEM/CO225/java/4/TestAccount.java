class TestAccount { 
    public static void main(String [] args) { 
	Account acc = new Account("057-12122-1223-12"); 
	addMoney(acc, 1000f); 
    }

    public static void addMoney(Account acc, float value) { 
	acc.deposit(value); 
	acc.show(); 
    }
}