package main.java.com.solvd.people;

import main.java.com.solvd.financialInstitutions.FinancialInstitution;

import org.apache.log4j.Logger;

import main.java.com.solvd.credits.Credit;
import main.java.com.solvd.enums.ScoreLevel;
import main.java.com.solvd.exceptions.CreditNotApprovedException;

public class CreditManager extends Employee {
	private static final Logger logger = Logger.getLogger(CreditManager.class);
	private ScoreLevel requiredScoreLevel;

	public CreditManager() {
	}

	public CreditManager(String name, String lastname, int identification, String gender, int age, String nationality,
			String department, FinancialInstitution company, float salary, ScoreLevel requiredScoreLevel) {
		super(name, lastname, identification, gender, age, nationality, department, company, salary);
		this.requiredScoreLevel= requiredScoreLevel;
	}

	public void evaluateCredits() {
		this.getCompany().getCredits().forEach(credit -> determineCreditState(credit));
	}

	private void determineCreditState(Credit credit) {
		if (credit.getScore() < requiredScoreLevel.getMinimum())
			credit.setDeclined();
		else {
			credit.setApproved();
			try {
				credit.getApplicant().addCredit(credit);
			} catch (CreditNotApprovedException e) {
				logger.error(e);
			}
		}
	}

	public ScoreLevel getRequiredScoreLevel() {
		return requiredScoreLevel;
	}

	public void setRequiredScoreLevel(ScoreLevel requiredScoreLevel) {
		this.requiredScoreLevel = requiredScoreLevel;
	}

}
