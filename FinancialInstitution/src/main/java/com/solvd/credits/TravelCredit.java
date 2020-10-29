package main.java.com.solvd.credits;

import main.java.com.solvd.exceptions.DateFromGreaterThanDateToException;
import main.java.com.solvd.people.Client;
import main.java.com.solvd.people.Person;

import java.util.Date;

import org.apache.log4j.Logger;

public class TravelCredit extends Credit{
	private static final Logger logger = Logger.getLogger(TravelCredit.class);
	private String destination;
	private Date dateFrom;
	private Date dateTo;
	
	public TravelCredit() {}

	public TravelCredit(int id, float amount, float interest, int fees, Client applicant, String destination, Date dateFrom, Date dateTo) {
		super(id, amount, interest, fees, applicant);
		this.destination = destination;
		
		try {
			if (dateFrom.after(dateTo)) {
				throw new DateFromGreaterThanDateToException(dateFrom, dateTo);
			}
			this.dateFrom = dateFrom;
			this.dateTo = dateTo;
		} catch (DateFromGreaterThanDateToException e) {
			logger.error(e.getMessage());
		}
	}
	
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) throws DateFromGreaterThanDateToException {
		if (dateFrom.after(dateTo)) {
			throw new DateFromGreaterThanDateToException(dateFrom, dateTo);
		}
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) throws DateFromGreaterThanDateToException {
		if (dateFrom.after(dateTo)) {
			throw new DateFromGreaterThanDateToException(dateFrom, dateTo);
		}
		this.dateTo = dateTo;
	}
	
	
	
}
