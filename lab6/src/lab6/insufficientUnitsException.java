package lab6;

import java.io.Serializable;

public class insufficientUnitsException extends Exception implements Serializable{
	public	static	final long serialVersionUID = 42L;
	public insufficientUnitsException(String message) {
		super(message);
	}
}
