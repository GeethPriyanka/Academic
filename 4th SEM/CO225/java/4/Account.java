public class Account { 
    /* attributes of an account */
    private float balance; 
    private String accountNumber; 
    private Customer customer; 

    public Account(String accountNumber) { 
	this.balance = 0; 
	this.accountNumber = accountNumber; 
	this.customer = null; 
    }

    /* methods that can be invoked on an account object */
    public float getBalance() { 
	return this.balance; 
    }    
    public void deposit(float amount) { 
	this.balance += amount; 
    }
    public void withdraw(float amount) { 
	if(getBalance() > amount)
	    balance -= amount; 
	else 
	    System.out.println("This cannot happen");
    }
    public void calculat_interst() { 
	balance *= 1.1;
    }
    public void setCustomer(Customer customer) { 
	this.customer = customer; 
    }
    public void show() { 
	System.out.println("Account Number: " + this.accountNumber); 
	if(this.customer == null) 
	    System.out.println("Inactive account"); 
	else 
	    this.customer.show(); 
    }
}

    