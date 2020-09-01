package lab6;
import java.util.*;
import java.io.*;
final public class Category implements Serializable{
	public	static	final long serialVersionUID = 42L;
	private final String name;
	private final Category parent;
	private HashMap<String, Category> cmap;
	private HashMap<String, Product> pmap;
	private Product product;
	public Category(String name,Category parent) {
		super();
		this.name= name;
		this.parent = parent;
		this.cmap = new HashMap<>();
		this.pmap = new HashMap<>();
	}

	public void addSubCategory(String scat,Category cat)
	{
		cmap.put(scat,cat);
	}

	public void addProduct(Product p)
	{
		pmap.put(p.getName(),p);
	}

	public boolean containsSubCategory(String s)
	{
		return (cmap.containsKey(s));
	}

	public Category getSubCategory(String s)
	{
		return cmap.get(s);
	}
	public Product getProduct(String s)
	{
		return pmap.get(s);
	}

	public boolean containsProduct(String s)
	{
		return (pmap.containsKey(s));
	}

	public void removeSubCategory(String s)
	{
		cmap.remove(s);
	}
	public void removeProduct(String s)
	{
		pmap.remove(s);
	}

	public String getName() {
		return name;
	}

	public Product searchProduct(String productName) {

		Set<String> keys = cmap.keySet();
		int size = keys.size();
		Product search = null;
		for(int i=0;i<size;i++)
		{
			Iterator<String> itr = keys.iterator();
			while(itr.hasNext())
			{
				Category current = cmap.get(itr.next());
				if(current.cmap.keySet().size()==0)
				{
					if(current.containsProduct(productName))
					{
						search = current.getProduct(productName);
//						search.displayPath();
//						search.displayDetails();
						return search;
					}

				}
				else
				{
					search = current.searchProduct(productName);
				}
			}
		}
		return search;



	}
	
	public void show()
	{
		Set<String> keys = cmap.keySet();
		int size = keys.size();
		Iterator<String> itr = keys.iterator();
		while(itr.hasNext())
		{
			String s =itr.next();
			Category c = cmap.get(s);
			System.out.println(s);
		}
	}

	@Override
	public boolean equals(Object o) {
		if(o!=null && getClass()== o.getClass())
		{
			Category c1 = (Category)o;
//			private final String name;
//			private final Category parent;
//			private HashMap<String, Category> cmap;
//			private HashMap<String, Product> pmap;
//			private Product product;
			
			boolean a = cmap.equals(c1.cmap);
			boolean b = pmap.equals(c1.pmap);
			boolean c = true;
			if(product!=null)
			{c = (product.equals(c1.product));}
			
//			System.out.println("A="+a);
//			System.out.println("B="+b);			
			if(name.equals(c1.getName()) && a && b && c)
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

//	@Override
//	public String toString() {
//		return "Category [name=" + name + ", parent=" + parent + ", cmap=" + cmap + ", pmap=" + pmap + ", product="
//				+ product + "]";
//	}
	@Override
	public String toString() {
		return "Category [name=" + name + ", parent=" + parent + ",product="
				+ product + "]";
	}
	

	
	
	
	
	
	
	
}
