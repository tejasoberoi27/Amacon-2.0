package lab6;
import java.io.*;
final public class Customer implements Serializable{
	public	static	final long serialVersionUID = 42L;
	private String name;
	private int funds;
	private Cart shoppingCart;
	public Customer(String name,Cart cart)
	{
		this.name = name;
		funds =0;
		shoppingCart= cart;
	}
	
	public void addFunds(int funds)
	{
		this.funds+=funds;
		System.out.println("Funds =" + this.funds);
	}
	
	public void addProduct(String ProdName,int quantity) throws NotExistingException, insufficientUnitsException
	{
		shoppingCart.addProduct(ProdName, quantity);
	}

	public void CheckOut() throws insufficientUnitsException, insufficientFundsException
	{
		funds = shoppingCart.checkOut(funds);
		System.out.println(this);
		System.out.println("checking out");
	}

	public String getName() {
		return name;
	}

//	@Override
//	public String toString() {
//		return "Customer [name=" + name + ", funds=" + funds + "]";
//	}

	public Cart getShoppingCart() {
		return shoppingCart;
	}
	
	public Cart getNewShoppingCart(Database db) {
		return new Cart(db);
	}

	public void setShoppingCart(Cart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", funds=" + funds + ", shoppingCart=" + shoppingCart + "]";
	}
	
	
	

	
	
	
	
}

