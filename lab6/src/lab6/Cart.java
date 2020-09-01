package lab6;
import java.util.*;
import java.io.*;
final public class Cart implements Serializable{
	public	static	final long serialVersionUID = 42L;
	private ArrayList<Product>products;
	private HashMap<Product, Integer> quant = new HashMap<>();
	private Database db;

	public Cart(Database db) {
		super();
		this.products = new ArrayList<Product>();
		this.quant = new HashMap<Product, Integer>();
		this.db = db;
	}

	public void addProduct(String ProdName,int quantity) throws NotExistingException,insufficientUnitsException
	{
		Product p = db.search(ProdName);
		if(p!=null)
		{

			if(quantity<=p.getNumUnits())
			{
				products.add(p);
				quant.put(p,quantity);
				p.decQuant(quantity);				
			}
			else
			{
				throw new insufficientUnitsException("Insufficient units of "+ ProdName); 
			}
			

		}
		else
		{
			throw new NotExistingException(ProdName+ "does not exist");
		}
	}

	public int checkOut(int funds) throws insufficientUnitsException, insufficientFundsException
	{
		int n = products.size();
		for(int i=0;i<n;i++)
		{	
			Set<Product> keys = quant.keySet();
			int size = keys.size();
			Iterator<Product> itr = keys.iterator();
			while(itr.hasNext())
			{
				Product currentProd =itr.next();
				int quantity = quant.get(currentProd);
				int transaction =  db.sale(currentProd,quantity,funds);
				funds-=(transaction);
			}
		}
		
		return funds;
	}

	public void setDb(Database db) {
		this.db = db;
	}

//	this.products = new ArrayList<Product>();
//	this.quant = new HashMap<Product, Integer>();
//	this.db = db;
	
	
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if(o!=null && getClass()== o.getClass())
		{
			Cart d1 = (Cart)o;
			
			boolean a = products.equals(d1.products);
			boolean b = (quant.equals(d1.quant));
			boolean c = db.equals(d1.db);
			if( a&&b&&c )
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	
	
}