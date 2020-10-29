package main.java.com.solvd.exceptions;

public class DivideByZeroException extends Exception{
	private static final long serialVersionUID = 1072352605231423753L;
	private static final String MESSAGE = "It is not posible divide by zero";

	public DivideByZeroException() {
		super(MESSAGE);
	}

	public DivideByZeroException(Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(MESSAGE, cause, enableSuppression, writableStackTrace);
	}

	public DivideByZeroException(Throwable cause) {
		super(MESSAGE, cause);
	}
	
	public String getMessage() {
		return MESSAGE;
	}
}
