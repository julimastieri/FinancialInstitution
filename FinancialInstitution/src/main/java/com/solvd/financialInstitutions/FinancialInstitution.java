package main.java.com.solvd.financialInstitutions;

import main.java.com.solvd.interfaces.Contactable;
import main.java.com.solvd.interfaces.ISignatory;
import main.java.com.solvd.credits.Credit;
import main.java.com.solvd.people.Employee;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public abstract class FinancialInstitution implements ISignatory, Contactable{
	private static final Logger logger = Logger.getLogger(FinancialInstitution.class);
	
	private int identification;
	private String name;
	private List<Employee> employees = new ArrayList<Employee>();
	private List<Credit> credits = new ArrayList<Credit>();
	
	public FinancialInstitution() {}
	
	public FinancialInstitution(int identification, String name) {
		this.identification = identification;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return identification;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FinancialInstitution other = (FinancialInstitution) obj;
		if (credits == null) {
			if (other.credits != null)
				return false;
		} else if (!credits.equals(other.credits))
			return false;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (identification != other.identification)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder employeesString = new StringBuilder(); 
		employees.forEach(emp -> employeesString.append("-" + emp.toString() + "\n"));
	
			
		StringBuilder creditsString = new StringBuilder(); 
		credits.forEach(cred -> creditsString.append("-" + cred.toString() + "\n"));
	        
		return ("Identification: "+ identification + "\n Name: "+ name + 
				"\n\nEmployees: \n" + employeesString +
				"\nCredits: \n" + creditsString
				);
	}
	
	@Override
	public String sign() {
		return name + identification;
	}
	
	@Override 
	public void sendEmail() {
		logger.info(Contactable.MESSAGE + name);
	}

	public int getIdentification() {
		return identification;
	}

	public void setIdentification(int identification) {
		this.identification = identification;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void addEmployee(Employee employee) {
		this.employees.add(employee);
	}
	
	public List<Credit> getCredits() {
		return credits;
	}
	
	public void addCredit(Credit credit) {
		this.credits.add(credit);
	}
	
}
