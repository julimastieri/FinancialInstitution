package main.java.com.solvd.exceptions;

import main.java.com.solvd.credits.Credit;

public class CreditNotApprovedException extends Exception{
	private static final long serialVersionUID = -1258655203419568402L;	
	private static final String MESSAGE = "The following credit is not approved: \n";
	
	private Credit credit;

	public CreditNotApprovedException() {}

	public CreditNotApprovedException(Credit credit, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(MESSAGE+credit.toString(), cause, enableSuppression, writableStackTrace);
		this.credit = credit;
	}

	public CreditNotApprovedException(Credit credit, Throwable cause) {
		super(MESSAGE+credit.toString(), cause);
		this.credit = credit;
	}

	public CreditNotApprovedException(Credit credit) {
		super(MESSAGE+credit.toString());
		this.credit = credit;
	}

	public Credit getCredit() {
		return credit;
	}
	
	public String getMessage() {
		return MESSAGE+credit.toString();
	}
	
	

}
