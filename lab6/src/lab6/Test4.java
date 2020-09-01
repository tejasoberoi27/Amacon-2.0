package lab6;

import java.io.ByteArrayInputStream;
import java.io.*;


import	org.junit.Test;	

public	class	Test4	{

	Database db1 = new Database();
	Cart c1 = new Cart(db1);
	@Test(expected	=	insufficientUnitsException.class)	
	public	void	testAddProduct() throws NotExistingException, NotNewException, insufficientUnitsException 	{	
		System.out.println("New Test Case");
		System.out.println("Testing the addProduct function for the exception: \"insufficientUnitsException\"");
		System.out.println("Adding an out-of-stock product \"Prod1\"" );
		String input = "100 2";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		db1.insert("a>b", "Prod1");
		String input2 = "150 3";
		c1.addProduct("Prod1",4);
		
	}	
}	