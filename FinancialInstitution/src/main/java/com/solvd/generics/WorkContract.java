package main.java.com.solvd.generics;

import main.java.com.solvd.financialInstitutions.FinancialInstitution;
import main.java.com.solvd.people.Employee;

public class WorkContract<E extends Employee, F extends FinancialInstitution> {
	private E employee;
	private F financialInstitution;
	
	public WorkContract() {}

	public WorkContract(E employee, F financialInstitution) {
		super();
		this.employee = employee;
		this.financialInstitution = financialInstitution;
	}

	public E getEmployee() {
		return employee;
	}

	public F getFinancialInstitution() {
		return financialInstitution;
	}
	
	public void sign() {
		employee.sign();
		financialInstitution.sign();
	}
	
	
}
