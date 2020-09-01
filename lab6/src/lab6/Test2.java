package lab6;

import java.io.ByteArrayInputStream;
import java.io.*;

	
import	org.junit.Test;	

public	class	Test2	{
	
	Database db1 = new Database();
	
	@Test(expected	=	NotExistingException.class)	
	public	void	testDelete() throws NotExistingException, NotNewException 	{	
		System.out.println("New Test Case");
		System.out.println("Testing the delete function for the exception: \"NotExistingException\"");
		System.out.println("Deleting the non-existent product \"Prod0\" at the path \"a>b\" " );
		String input = "100 2";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		db1.insert("a>b", "Prod1");
		String input2 = "150 3";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		db1.insert("a>b>c", "Prod2");
		db1.delete("a>b>Prod0");
	}	
}	