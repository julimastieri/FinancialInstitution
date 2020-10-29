package main.java.com.solvd.credits;

import java.util.Calendar;

import org.apache.log4j.Logger;

import main.java.com.solvd.exceptions.ExceededCurrentYearException;
import main.java.com.solvd.people.Client;
import main.java.com.solvd.people.Person;

public class CarCredit extends Credit{
	private static final Logger logger = Logger.getLogger(CarCredit.class);
	
	private String licensePlate;
	private String brand;
	private String model;
	private int modelYear;
	
	public CarCredit() {}
	
	public CarCredit(int id, float amount, float interest, int fees, Client applicant, String licensePlate, String brand, String model, int modelYear) {
		super(id, amount, interest, fees, applicant);
		this.licensePlate = licensePlate;
		this.brand = brand;
		this.model = model;
		
		try {
			setModelYear(modelYear);
		} catch (ExceededCurrentYearException e) {
			logger.error(e.getMessage());
		}
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) throws ExceededCurrentYearException {
		if (modelYear > Calendar.getInstance().get(Calendar.YEAR)) {
			throw new ExceededCurrentYearException(modelYear);
		}
		this.modelYear = modelYear;
	}
}
