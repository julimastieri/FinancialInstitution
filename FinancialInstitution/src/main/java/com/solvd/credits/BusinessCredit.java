package main.java.com.solvd.credits;

import main.java.com.solvd.people.Client;

public class BusinessCredit extends Credit{
	private String businessName;
	private String businessDescription;
	private String investmentDescription;
	
	public BusinessCredit() {}

	public BusinessCredit(int id, float amount, float interest, int fees, Client applicant, String businessName, String businessDescription, String investmentDescription) {
		super(id, amount, interest, fees, applicant);
		this.businessName = businessName;
		this.businessDescription = businessDescription;
		this.investmentDescription = investmentDescription;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessDescription() {
		return businessDescription;
	}

	public void setBusinessDescription(String businessDescription) {
		this.businessDescription = businessDescription;
	}

	public String getInvestmentDescription() {
		return investmentDescription;
	}

	public void setInvestmentDescription(String investmentDescription) {
		this.investmentDescription = investmentDescription;
	}
	
}
