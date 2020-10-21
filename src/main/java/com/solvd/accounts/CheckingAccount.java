package main.java.com.solvd.accounts;

import main.java.com.solvd.interfaces.Invertible;

public class CheckingAccount implements IAccount, Invertible{
	private double maintenanceFee;
	private double deposits;
	private double withdrawals;
	
	public CheckingAccount() {}
	
	public CheckingAccount(double maintenanceFee, double deposits, double withdrawals) {
		this.maintenanceFee = maintenanceFee;
		this.deposits = deposits;
		this.withdrawals = withdrawals;
	}
	
	@Override
	public double getBalance() {
		return deposits-withdrawals;
	}
	@Override
	public void deposit(double amount) {
		deposits += amount;
	}
	@Override
	public void withdraw(double amount) {
		withdrawals += amount;
	}

	public double getMaintenanceFee() {
		return maintenanceFee;
	}

	public double getDeposits() {
		return deposits;
	}

	public double getWithdrawals() {
		return withdrawals;
	}

	@Override
	public void invest(double amount) {
		withdrawals += amount;
	}
	
}
