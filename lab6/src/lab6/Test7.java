package lab6;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Before;
import	org.junit.Test;	

public class Test7 {

	static Amacon a1 = new Amacon();
	static Database db1 = new Database();
	static Cart c1 = new Cart(db1);
	static Customer cm1 = new Customer("CM1", c1);
	
	@Before
	public void setup() throws NotNewException, NotExistingException, ClassNotFoundException, IOException, insufficientUnitsException
	{
		String input = "100 2";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		db1.insert("a>b", "Prod1");
		String input2 = "150 3";
		InputStream in2 = new ByteArrayInputStream(input2.getBytes());
		System.setIn(in2);
		db1.insert("a>b", "Prod2");
		cm1.addFunds(4000);
		cm1.addProduct("Prod2", 3);
		cm1.addProduct("Prod1", 1);
		Amacon.serializeCust(cm1);	
	}
	
	@Test
	public	void testSerializeDatabase() throws NotExistingException, NotNewException, ClassNotFoundException, IOException 	{	
		System.out.println("New Test Case");
		System.out.println("Testing the serialization of customer cart");
		Customer c2 = Amacon.deserializeCust(cm1);
		assertEquals(c1,c2.getShoppingCart());
		
	}	
}
