public class Account { 

    float balance; 
    public Account(float balance) { 
	this.balance = balance; 
    }

    public void withdraw(float amount) 
	throws Exception { 
	if(this.balance < amount) throw new Exception(); 
	
	this.balance -= amount; 
    }

    public void withdraw_assert(float amount) {
	assert amount < this.balance : "Not enough money"; 
	
	this.balance -= amount; 
    }

    public static void callWithdraw() { 
	// just to show the call graph when it fails 
	Account b = new Account(12); 
	b.withdraw_assert(100f); 
    }

    public static void main(String [] args) { 
	Account a = new Account(34f); 
	try { 
	    a.withdraw(123f); 
	} catch(Exception e) { 
	    System.out.println("Got an exception"); 
	}

	callWithdraw(); 
    }
}