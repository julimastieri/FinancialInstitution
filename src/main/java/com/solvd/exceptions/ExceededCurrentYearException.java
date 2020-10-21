package main.java.com.solvd.exceptions;

public class ExceededCurrentYearException extends Exception{
	private static final long serialVersionUID = 2422509086554966018L;
	
	private static final String MESSAGE = " is greater than the current year.";

	private int year;

	public ExceededCurrentYearException() {}

	public ExceededCurrentYearException(int year, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(year+MESSAGE, cause, enableSuppression, writableStackTrace);
		this.year = year;
	}

	public ExceededCurrentYearException(int year, Throwable cause) {
		super(year+MESSAGE, cause);
		this.year = year;
	}

	public ExceededCurrentYearException(int year) {
		super(year+MESSAGE);
		this.year = year;
	}

	public ExceededCurrentYearException(Throwable cause) {
		super(cause);
	}
	
	public String getMessage() {
		return year+MESSAGE;
	}
	
	public double getYear() {
		return year;
	}

}
