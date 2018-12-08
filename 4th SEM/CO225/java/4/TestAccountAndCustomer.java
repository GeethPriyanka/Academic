class TestAccountAndCustomer { 
    public static void main(String [] args) { 
	
	String accNumber = "057-121-3234-4431"; 
	
	Account acc = new Account(accNumber); 
	// create a new customer and associate this account with him/her
	Customer cus = new 
	    Customer("Dhammika Elkaduwe", "1234", accNumber, acc); 

	acc.setCustomer(cus); // set the customer of account
	acc.show(); 
	depositMoney(acc, 3000f); // pass by reference 
	System.out.printf("\nAfter depositing..");
	acc.show(); 	
    }

    public static void depositMoney(Account acc, float val){ 
	acc.deposit(val); 
    }
    
}
	