package lab6;

import java.io.ByteArrayInputStream;
import java.io.*;


import	org.junit.Test;	

public	class	Test3	{

	Database db1 = new Database();

	@Test(expected	=	NotExistingException.class)	
	public	void	testSearch() throws NotExistingException, NotNewException 	{	
		System.out.println("New Test Case");
		System.out.println("Testing the search function for the exception: \"NotExistingException\"");
		System.out.println("Searching the non-existent product \"Prod0\"" );
		String input = "100 2";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		db1.insert("a>b", "Prod1");
		String input2 = "150 3";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		db1.insert("a>b>c", "Prod2");
		db1.search("Prod0");
	}	
}	