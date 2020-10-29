package main.java.com.solvd.credits;

import main.java.com.solvd.exceptions.ExpiredDateException;
import main.java.com.solvd.people.*;

import java.util.Date;

import org.apache.log4j.Logger;

public class WeddingCredit extends Credit{
	private static final Logger logger = Logger.getLogger(WeddingCredit.class);
	private String location;
	private Person husband;
	private Person wife;
	private Date date;
	
	public WeddingCredit() {}

	public WeddingCredit(int id, float amount, float interest, int fees, Client applicant, String location, Person husband, Person wife, Date date) {
		super(id, amount, interest, fees, applicant);
		this.location = location;
		this.husband = husband;
		this.wife = wife;
		
		try {
			setDate(date);
		} catch (ExpiredDateException e) {
			logger.error(e.getMessage());
		}
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Person getHusband() {
		return husband;
	}

	public void setHusband(Person husband) {
		this.husband = husband;
	}

	public Person getWife() {
		return wife;
	}

	public void setWife(Person wife) {
		this.wife = wife;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) throws ExpiredDateException{
		if (date.before(new Date()))
			throw new ExpiredDateException(date);
		this.date = date;
	}
	
}
