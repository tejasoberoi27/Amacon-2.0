package lab6;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Before;
import	org.junit.Test;	

public class Test6 {
	
	static Amacon a1 = new Amacon();
	static Database db1 = new Database();
	@Before
	public void setup() throws NotNewException, NotExistingException, ClassNotFoundException, IOException
	{
		String input = "100 2";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		a1.getDb().insert("a>b", "Prod1");
		String input2 = "150 3";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		a1.getDb().insert("a>b>c", "Prod2");
		db1 = a1.getDb();
		Amacon.serializeDb(a1);	
	}
	
	@Test
	public	void testSerializeDatabase() throws NotExistingException, NotNewException, ClassNotFoundException, IOException 	{	
		System.out.println("New Test Case");
		System.out.println("Testing the serialization of database");
		Amacon.deserializeDb(a1);
		assertEquals(db1, a1.getDb());
		
	}	
}
