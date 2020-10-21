package main.java.com.solvd.exceptions;

import java.util.Date;

public class DateFromGreaterThanDateToException extends Exception {
	private static final long serialVersionUID = 3449250803905085305L;

	private Date dateFrom;
	private Date dateTo;

	public DateFromGreaterThanDateToException() {}

	public DateFromGreaterThanDateToException(Date dateFrom, Date dateTo, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(dateFrom.toString() + "is greater than " + dateTo.toString(), cause, enableSuppression, writableStackTrace);
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}

	public DateFromGreaterThanDateToException(Date dateFrom, Date dateTo, Throwable cause) {
		super(dateFrom.toString() + "is greater than " + dateTo.toString(), cause);
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}

	public DateFromGreaterThanDateToException(Date dateFrom, Date dateTo) {
		super((dateFrom.toString() + "is greater than " + dateTo.toString()));
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}

	public DateFromGreaterThanDateToException(Throwable cause) {
		super(cause);
	}

	public String getMessage() {
		return dateFrom.toString() + "is greater than " + dateTo.toString();
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

}
