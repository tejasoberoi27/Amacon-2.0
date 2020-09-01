package lab6;

import java.io.ByteArrayInputStream;
import java.io.*;

/*	Junit testcase	class-1	*/	
import	org.junit.Test;	

public	class	Test1	{
	
	Database db1 = new Database();
	
	@Test(expected	=	NotNewException.class)	
	public	void	testAddProduct() throws NotNewException 	{	
		System.out.println("New Test Case");
		System.out.println("Testing the insert function for the exception: \"NotNewException\"");
		System.out.println("Inserting the product \"Prod0\" at the path \"a>b\" " );
		String input = "100 2";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		db1.insert("a>b", "Prod0");
		String input2 = "150 3";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		db1.insert("a>b", "Prod0");
	}	
}	