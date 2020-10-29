package main.java.com.solvd.exceptions;

public class NegativeNumberException extends Exception{
	private static final long serialVersionUID = -8027813352107555515L;
	private static final String MESSAGE = " is a negative number. Negative numbers are not allowed.";
	
	private double number;

	public NegativeNumberException() {}

	public NegativeNumberException(double number, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(number+MESSAGE, cause, enableSuppression, writableStackTrace);
		this.number = number;
	}

	public NegativeNumberException(double number, Throwable cause) {
		super(number+MESSAGE, cause);
		this.number = number;
	}

	public NegativeNumberException(double number) {
		super(number+MESSAGE);
		this.number = number;
	}

	public NegativeNumberException(Throwable cause) {
		super(cause);
	}
	
	public String getMessage() {
		return number+MESSAGE;
	}
	
	public double getNumber() {
		return number;
	}
	
}
