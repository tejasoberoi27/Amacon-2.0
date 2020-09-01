package lab6;

import java.io.*;
import java.util.Scanner;

public class Admin implements Serializable{
	public	static	final long serialVersionUID = 42L;
	transient private static Scanner sc;
	private Database db;
	public Admin(Database db)
	{
		this.db=db;
		sc = new Scanner(System.in);
	}
	
	public void insert() throws NotNewException
	{
//		if(db==null)
//		{
//			System.out.println("null");
//		}
		db.insert(this);
	}
	
	public void delete() throws NotExistingException
	{
		db.delete(this);
	}
	
	public void search() throws NotExistingException 
	{
		System.out.println("Enter the product you wish to search.");
		db.search(sc.next());
	}
	public void modify() 
	{
		db.modify(this);
	}

	@Override
	public String toString() {
		return "Admin [db=" + db + "]";
	}
	
	
}
