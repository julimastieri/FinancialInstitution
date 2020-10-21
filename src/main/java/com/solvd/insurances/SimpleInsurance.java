package main.java.com.solvd.insurances;

import org.apache.log4j.Logger;

import main.java.com.solvd.exceptions.NegativeNumberException;


public class SimpleInsurance implements IInsurance {
	private static final Logger logger = Logger.getLogger(SimpleInsurance.class);
	
	private String denomination;
	private String description;
	private double premium;
	private double policyLimit;

	public SimpleInsurance() {
	}

	public SimpleInsurance(String denomination, String description, double premium, double policyLimit) {
		this.denomination = denomination;
		this.description = description;
		this.premium = premium;
		
		try {
			setPolicyLimit(policyLimit);
		}
		catch (NegativeNumberException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public double calculateCost() {
		return getPremium();
	}

	public String getDenomination() {
		return denomination;
	}

	public String getDescription() {
		return description;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public double getPolicyLimit() {
		return policyLimit;
	}

	public void setPolicyLimit(double policyLimit) throws NegativeNumberException {
		if (policyLimit < 0)
			throw new NegativeNumberException(premium);
		this.policyLimit = policyLimit;
	}
}
