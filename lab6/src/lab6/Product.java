package lab6;
import java.io.Serializable;
import java.io.*;
final public class Product implements Serializable{
	public	static	final long serialVersionUID = 42L;
	public static int code =0;
	public int hash;
	private String path;
	private Category parent;
	private String name;
	private int price;
	private int numUnits;
	public Product(String name,String path,int price,int numUnits) {
		this.name = name;
		this.path = path;
		this.price = price;
		this.numUnits = numUnits;
		hash = code;
		code++;
		
	}
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if(o!=null && getClass()== o.getClass())
		{
			Product p1 = (Product)o;
			return(name.equalsIgnoreCase(p1.getName()) && path.equalsIgnoreCase(p1.path));
		}
		else
		{
			return false;
		}
	}
	
	public int hashCode()
	{
		return hash;
	}
	public String getName() {
		return name;
	}
	
	public void displayPath()
	{
		System.out.println(path);
	}
	
	public void displayDetails()
	{
		System.out.println("price: "+ price+" units: "+numUnits);
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setNumUnits(int numUnits) {
		this.numUnits = numUnits;
	}
	public int getPrice() {
		return price;
	}
	public int getNumUnits() {
		return numUnits;
	}
	public void decQuant(int diff) {
		this.numUnits -=(diff);// TODO Auto-generated method stub
	}
	@Override
	public String toString() {
		return "Product [hash=" + hash + ", path=" + path + ", parent=" + parent + ", name=" + name + ", price=" + price
				+ ", numUnits=" + numUnits + "]";
	}
	
	
	
	
	
	
	
}
