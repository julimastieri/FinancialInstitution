package main.java.com.solvd.exceptions;

import java.util.Date;

public class ExpiredDateException extends Exception{
	private static final long serialVersionUID = 4677003917480829674L;

	private static final String MESSAGE = "The following date has expired: ";
	
	private Date date;

	public ExpiredDateException() {}

	public ExpiredDateException(Date date, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(MESSAGE+date.toString(), cause, enableSuppression, writableStackTrace);
		this.date = date;
	}

	public ExpiredDateException(Date date, Throwable cause) {
		super(MESSAGE+date.toString(), cause);
		this.date = date;
	}

	public ExpiredDateException(Date date) {
		super(MESSAGE+date.toString());
		this.date = date;
	}

	public ExpiredDateException(Throwable cause) {
		super(cause);
	}
	
	public String getMessage() {
		return MESSAGE+date.toString();
	}
	
	public Date getDate() {
		return date;
	}
}
