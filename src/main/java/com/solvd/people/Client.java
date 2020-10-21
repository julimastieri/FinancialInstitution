package main.java.com.solvd.people;

import main.java.com.solvd.credits.Credit;
import main.java.com.solvd.enums.CreditStatus;
import main.java.com.solvd.exceptions.CreditNotApprovedException;

import java.util.ArrayList;

public class Client extends Person{
	private String profession;
	private String currentJob;
	private float salary;
	private int accountNumber;
	private ArrayList<Credit> credits  = new ArrayList<Credit>();
	
	public Client() {}

	public Client(String name, String lastname, int identification, String gender, int age, String nationality, String profession, float salary, int accountNumber) {
		super(name, lastname, identification, gender, age, nationality);
		this.profession = profession;
		this.salary = salary;
		this.accountNumber = accountNumber;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getCurrentJob() {
		return currentJob;
	}

	public void setCurrentJob(String currentJob) {
		this.currentJob = currentJob;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public ArrayList<Credit> getCredits() {
		return credits;
	}

	public void addCredit(Credit credit) throws CreditNotApprovedException {
		if (!credit.getState().equals(CreditStatus.APPROVED)) {
			throw new CreditNotApprovedException(credit);
		}
		this.credits.add(credit);
	}
	
}
