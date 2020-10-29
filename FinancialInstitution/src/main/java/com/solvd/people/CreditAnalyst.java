package main.java.com.solvd.people;

import main.java.com.solvd.financialInstitutions.FinancialInstitution;
import main.java.com.solvd.credits.*;
import main.java.com.solvd.exceptions.DivideByZeroException;

import java.util.Date;

import org.apache.log4j.Logger;

public class CreditAnalyst extends Employee {
	private static final Logger logger = Logger.getLogger(CreditAnalyst.class);

	public CreditAnalyst() {}

	public CreditAnalyst(String name, String lastname, int identification, String gender, int age, String nationality,
			String department, FinancialInstitution company, float salary) {
		super(name, lastname, identification, gender, age, nationality, department, company, salary);
	}

	public void generateHomeMortgageCreditSolicitation(int id, float amount, float interest, int fees, Client applicant,
			int addressNumber, String addressStreet) {
		HomeMortgageCredit homeCredit = new HomeMortgageCredit(id, amount, interest, fees, applicant, addressNumber,
				addressStreet);
		generateCreditScore(homeCredit);
		this.getCompany().addCredit(homeCredit);
	}

	public void generateCarCreditSolicitation(int id, float amount, float interest, int fees, Client applicant,
			String licensePlate, String brand, String model, int modelYear) {
		CarCredit carCredit = new CarCredit(id, amount, interest, fees, applicant, licensePlate, brand, model,
				modelYear);
		generateCreditScore(carCredit);
		this.getCompany().addCredit(carCredit);
	}
	
	public void generateStudentCreditSolicitation(int id, float amount, float interest, int fees, Client applicant, String studentName, int studentFileNumber, String career, int careerDuration) {
		StudentCredit studentCredit = new StudentCredit(id, amount, interest, fees, applicant, studentName, studentFileNumber, career, careerDuration);
		generateCreditScore(studentCredit);
		this.getCompany().addCredit(studentCredit);
	}

	public void generateTravelCreditSolicitation(int id, float amount, float interest, int fees, Client applicant,
			String destination, Date dateFrom, Date dateTo) {
		TravelCredit travelCredit = new TravelCredit(id, amount, interest, fees, applicant, destination, dateFrom,
				dateTo);
		generateCreditScore(travelCredit);
		this.getCompany().addCredit(travelCredit);
	}

	public void generateWeddingCreditSolicitation(int id, float amount, float interest, int fees, Client applicant, String location, Person husband, Person wife, Date date) {
		WeddingCredit weedingCredit = new WeddingCredit(id, amount, interest, fees, applicant, location, husband, wife, date);
		generateCreditScore(weedingCredit);
		this.getCompany().addCredit(weedingCredit);
	}
	
	public void generateBusinessCreditSolicitation(int id, float amount, float interest, int fees, Client applicant, String businessName, String businessDescription, String investmentDescription) {
		BusinessCredit businessCredit = new BusinessCredit(id, amount, interest, fees, applicant, businessName, businessDescription, investmentDescription);
		generateCreditScore(businessCredit);
		this.getCompany().addCredit(businessCredit);
	}

	private void generateCreditScore(Credit credit) {
		try {
			if (credit.getApplicant().getSalary() == 0)
				throw new DivideByZeroException();
		credit.setScore(100 - credit.getFeeAmount() * 100 / credit.getApplicant().getSalary());
		}catch (DivideByZeroException e) {
			logger.error(e.getMessage());
		}
	}
}
