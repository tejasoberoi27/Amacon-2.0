package lab6;

import java.io.*;


import	org.junit.Test;	

public	class	Test5	{

	Database db1 = new Database();
	Cart c1 = new Cart(db1);
	Customer cm1 = new Customer("CM1", c1);

	@Test(expected	=	insufficientFundsException.class)	
	public	void	testCheckOut() throws NotExistingException, NotNewException, insufficientUnitsException, insufficientFundsException 	{	
		System.out.println("New Test Case");
		System.out.println("Testing the checkOut function for the exception: \"insufficientFundsException\"");
		System.out.println("Adding 400 in funds to the customer and attempting a transaction of 450" );
		String input = "100 2";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		db1.insert("a>b", "Prod1");
		String input2 = "150 3";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		db1.insert("a>b", "Prod2");
		cm1.addFunds(400);
		cm1.addProduct("Prod2", 3);
		cm1.CheckOut();

	}	
}	