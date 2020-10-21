package main.java.com.solvd.exceptions;

public class MaximumWithdrawalsPerMonthException extends Exception {
	private static final long serialVersionUID = -4386776906569795499L;
	private static final String MESSAGE = "Maximum withdrawals per month exceeded";

	public MaximumWithdrawalsPerMonthException() {
		super(MESSAGE);
	}

	public MaximumWithdrawalsPerMonthException(Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(MESSAGE, cause, enableSuppression, writableStackTrace);
	}

	public MaximumWithdrawalsPerMonthException(Throwable cause) {
		super(MESSAGE, cause);
	}
	
	public String getMessage() {
		return MESSAGE;
	}

}
