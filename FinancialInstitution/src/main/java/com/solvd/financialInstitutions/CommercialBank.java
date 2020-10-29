package main.java.com.solvd.financialInstitutions;

public class CommercialBank extends FinancialInstitution{
	
	private String address;
	private int branchNumber;

	public CommercialBank() {}

	public CommercialBank(int identification, String name, String address, int branchNumber) {
		super(identification, name);
		this.address = address;
		this.branchNumber = branchNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBranchNumber() {
		return branchNumber;
	}

	public void setBranchNumber(int branchNumber) {
		this.branchNumber = branchNumber;
	}
	
	


	

}
