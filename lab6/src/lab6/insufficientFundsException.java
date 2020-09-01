package lab6;

import java.io.Serializable;

final public class insufficientFundsException extends Exception implements Serializable {
	public	static	final long serialVersionUID = 42L;
	public insufficientFundsException(String message) {
		super(message);
	}	
}
