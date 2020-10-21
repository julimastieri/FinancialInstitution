package main.java.com.solvd.people;

import main.java.com.solvd.financialInstitutions.FinancialInstitution;

public abstract class Employee extends Person{
	private String department;
	private FinancialInstitution company;
	private float salary;
	
	public Employee() {}

	public Employee(String name, String lastname, int identification, String gender, int age, String nationality, String department, FinancialInstitution company, float salary) {
		super(name, lastname, identification, gender, age, nationality);
		this.department = department;
		this.company = company;
		this.salary = salary;
		company.addEmployee(this);
	}
	
	@Override
	public String toString() {
		
		return (super.toString() + "\n Department: " + getDepartment() );
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public FinancialInstitution getCompany() {
		return company;
	}

	public void setCompany(FinancialInstitution company) {
		this.company = company;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
}
