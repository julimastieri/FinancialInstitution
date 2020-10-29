package main.java.com.solvd.credits;

import main.java.com.solvd.people.Client;

public class HomeMortgageCredit extends Credit{
	private int addressNumber;
	private String addressStreet;
	
	public HomeMortgageCredit() {}
	
	public HomeMortgageCredit (int id, float amount, float interest, int fees, Client applicant, int addressNumber, String addressStreet) {
		super (id, amount, interest, fees, applicant);
		this.addressNumber = addressNumber;
		this.addressStreet = addressStreet;
	}
	
	public int getAddressNumber() {
		return addressNumber;
	}
	
	public void setAddressNumber(int addressNumber) {
		this.addressNumber = addressNumber;
	}
	
	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}
	
}
