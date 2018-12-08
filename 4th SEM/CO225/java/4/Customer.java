public class Customer { 

    private String name;  
    private String pin; 
    private String accountNum; 
    private Account account; 

    public Customer(String name, String pin, 
		    String accountNum, Account account) { 
	this.name = name; 
	this.pin  = pin; 
	this.accountNum = accountNum; 
	this.account = account; 
    }

    public boolean check_pin(String pin) { 
	return this.pin.equals(pin);
    }

    public boolean check_name(String name) { 
	return this.name.equals(name); 
    }

    public Account getAccount(String name, String pin) { 
	if(check_name(name) && check_pin(pin)) 
	    return this.account; 
	else {
	    System.out.println("This cannot happen"); 
	    return null; 
	}	
    }
    public void show() { 
	System.out.println(name + " has Rs." + account.getBalance());
    }
}