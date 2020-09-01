package lab6;
import java.util.*; 
import java.io.*;



final class NotNewException extends Exception{

	public NotNewException(String message)
	{
		super(message);
	}
}

final class NotExistingException extends Exception{
	public	static	final long serialVersionUID = 42L;
	public NotExistingException(String message)
	{
		super(message);
	}
}

public final class Database implements Serializable{
	public	static	final long serialVersionUID = 42L;
	private Category root;
	private int revenue;
	transient private static Scanner sc;


	public Database() {


		this.root = new Category("",null);
		this.revenue = 0;
	}


	public void insert(Object o) throws NotNewException
	{
		if(o.getClass()==Admin.class)
		{sc = new Scanner(System.in);
		System.out.println("Enter the path for the product.");
		String s ="";
		boolean run = false;
		while(!run)
		{
			try
			{
				s = sc.next();
				run = true;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Enter valid strings");
				sc.next();
			}
		}

		System.out.println("Enter the name of the product.");
		String p ="";
		run = false;
		while(!run)
		{
			try
			{
				p = sc.next();
				run = true;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Enter valid strings");
				sc.next();
			}
		}
		insert(s,p);
		}
		else
		{
			System.out.println("Only an Admin has access");
		}

	}

	public void delete(Object o) throws NotExistingException
	{
		if(o.getClass()==Admin.class)
		{
			System.out.println("Enter the path of the product/category you wish to delete.");
			String deletion ="";
			boolean run = false;
			while(!run)
			{
				try
				{
					deletion = sc.next();
					delete(deletion);
					run = true;
				}
				catch(InputMismatchException e)
				{
					System.out.println("Enter valid string");
					sc.next();
				}
			}
			
		}
		else
		{
			System.out.println("Only an Admin has access");
		}

	}

	public void modify(Object o) 
	{
		if(o.getClass()==Admin.class)
		{
			System.out.println("Enter the product you wish to modify.");
			modify(sc.next());			
		}
		else
		{
			System.out.println("Only an Admin has access");
		}
	}



	public void insert(String path,String insertion) throws NotNewException
	{
		int found =0;
		int n = insertion.length();
		int s = 0;
		int last = 0;
		String cat;
		Category current = root;
		Category parent =root;
		Category subcategory = null;
		String prodPath = "";


		String[] catpath = path.split(">");
		//		for(String str: catpath)
		//		{
		//			System.out.println(str);
		//		}
		int size = catpath.length;

		for(int i =0;i<size;i++)
		{
			cat =  catpath[i];
			//			System.out.println("cat="+cat);
			if( !parent.containsSubCategory(cat))
			{
				current = new Category(cat,parent);
				parent.addSubCategory(cat,current);
			}
			else
			{
				current = parent.getSubCategory(cat);
				//				System.out.println("extant"+current.getName());
			}
			parent = current;


			if(i==size-1)
			{
				prodPath+=(parent.getName());
			}
			else
			{
				prodPath = prodPath + (parent.getName()+">");
			}

		}

		//		for(int i=0;i<n;i++)
		//		{
		//			if(path.charAt(i)=='>')
		//			{	
		//				System.out.println("in");
		//				found = 1;
		//				cat =  path.substring(s,i);
		//				System.out.println(cat.length());
		//				System.out.println(cat);
		//				s=i+1;
		//				last =i+1;
		//				if( !parent.containsSubCategory(cat))
		//				{
		//					current = new Category(cat,parent);
		//					parent.addSubCategory(cat,current);
		//				}
		//				parent = current;
		//				prodPath+=(parent.getName()+">");
		//				System.out.println(prodPath);
		//			}
		//			if(i==n-1||found==0)
		//			{
		//				cat = path.substring(last,n);
		//				if( !parent.containsSubCategory(cat))
		//				{
		//					current = new Category(cat,parent);
		//					parent.addSubCategory(cat,current);
		//				}
		//				parent = current;
		//				prodPath+=(parent.getName()+"");
		//			}
		//		}

		if(parent.containsProduct(insertion))
		{
			throw new NotNewException("Product/category already exists");
		}
		else
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter price and number of units of "+insertion+" separated by single space");

			int price =0;
			int NumUnits = 0;
			boolean run = false;
			while(!run)
			{
				try
				{
					price = sc.nextInt();
					NumUnits = sc.nextInt();
					run = true;
				}
				catch(InputMismatchException e)
				{
					System.out.println("Enter integers");
					sc.next();
				}
			}
			//			System.out.println("path= "+prodPath);
			Product product = new Product(insertion,prodPath,price,NumUnits);
			parent.addProduct(product);
		}

	}

	public void delete(String path) throws NotExistingException
	{
		int found =0;
		int n = path.length();
		int s = 0;
		int last = 0;
		String cat;
		Category parent =root;
		Category subcategory = null;
		//		System.out.println("show");
		//		parent.show();

		String[] catpath = path.split(">");
		int size = catpath.length;

		for(int i =0;i<size;i++)
		{
			cat =  catpath[i];

			if(i==size-1)
			{
				if( !parent.containsSubCategory(cat))
				{
					if(parent.containsProduct(cat))
					{
						//						System.out.println("prod exists");					
						parent.removeProduct(cat);
					}
					else
					{
						throw new NotExistingException("Product/subcategory does not exist");
					}					
				}
				else
				{
					//					System.out.println("cat exists");
					parent.removeSubCategory(cat);
				}
			}

			else
			{
				if(!parent.containsSubCategory(cat))
				{
					//					System.out.println("Cat="+cat);
					throw new NotExistingException("Product/subcategory "+cat+" does not exist");
				}
				else {
					//					System.out.println("exists");
					parent = parent.getSubCategory(cat);
				}
			}

		}
	}

	public Product search(String productName) throws NotExistingException
	{
		//		Product search = null;
		Category parent = root;		
		//		return parent.searchProduct(productName);
		Product search = parent.searchProduct(productName);
		if(search!=null)
		{
			search.displayPath();
			search.displayDetails();
		}
		else
		{
			throw new NotExistingException("Product " + productName+ " could not be found");
		}
		return search;
	}

	public void modify(String productName)
	{
		Category parent = root;		
		Product search = parent.searchProduct(productName);
		//		Product search = search(productName);
		if(search==null)
		{
			System.out.println("No such product exists");
		}
		else
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter new price and number of units of "+productName+" separated by single space");
			int price =0;
			int NumUnits = 0;
			boolean run = false;
			while(!run)
			{
				try
				{
					price = sc.nextInt();
					NumUnits = sc.nextInt();
					run = true;
				}
				catch(InputMismatchException e)
				{
					System.out.println("Enter integers");
					sc.next();
				}
			}
	
			search.setPrice(price);
			search.setNumUnits(NumUnits);
		}
	}

	public int sale(Product product,int quantity,int funds_left) throws insufficientUnitsException, insufficientFundsException
	{
		int total =product.getPrice()*quantity; 
		//		if(product.getNumUnits()< quantity)
		//		{
		//			throw new insufficientUnitsException("insufficient number of units");
		//		}
		if(total>funds_left)
		{
			throw new insufficientFundsException("insufficient funds left with the customer ");
		}
		//		product.setNumUnits(product.getNumUnits()-quantity);
		this.revenue+=(total);
		System.out.println(revenue);
		return total;	
	}

	public int calcRevenue()
	{
		return revenue;
	}



	public Category getRoot() {
		return root;
	}

	public void setRoot(Category root) {
		this.root = root;
	}

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if(o!=null && getClass()== o.getClass())
		{
			Database d1 = (Database)o;

			boolean a = revenue==d1.getRevenue();
			boolean b = (root.equals(d1.getRoot()));
			if( a&&b )
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

	@Override
	public String toString() {
		return "Database [root=" + root + ", revenue=" + revenue + "]";
	}






}
