package main.java.com.solvd.accounts;

import main.java.com.solvd.exceptions.MaximumWithdrawalsPerMonthException;

public class SavingAccount implements IAccount{
	private double balance;
	private int maxWithdrawalsPerMonth;
	private int numberOfWithdrawals;
	
	public SavingAccount() {}
	
	public SavingAccount(double balance, int maxWithdrawalsPerMonth, int numberOfWithdrawals) {
		this.balance = balance;
		this.maxWithdrawalsPerMonth = maxWithdrawalsPerMonth;
		this.numberOfWithdrawals = numberOfWithdrawals;
	}

	@Override
	public double getBalance() {
		return balance;
	}
	@Override
	public void deposit(double amount) {
		balance += amount;
	}
	@Override
	public void withdraw(double amount) throws MaximumWithdrawalsPerMonthException{
		if (numberOfWithdrawals >= maxWithdrawalsPerMonth) {
			throw new MaximumWithdrawalsPerMonthException();
		}
		balance -= amount;
		numberOfWithdrawals++;
	}
	
	public int getMaxWithdrawalsPerMonth() {
		return maxWithdrawalsPerMonth;
	}
	public int getNumberOfWithdrawals() {
		return numberOfWithdrawals;
	}
	
}
