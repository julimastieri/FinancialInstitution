package main.java.com.solvd.enums;

public enum CreditStatus {
	IN_EVALUATION("In evaluation"),
	APPROVED("Approved"),
	DECLINED("Declined");
	
	private String designation;
	
	CreditStatus(String designation) {
		this.designation = designation;
	}

	public String getDesignation() {
		return designation;
	}

}
