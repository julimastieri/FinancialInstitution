package main.java.com.solvd.accounts;

import main.java.com.solvd.exceptions.MaximumWithdrawalsPerMonthException;

public interface IAccount {
	 double getBalance();
	 void deposit(double amount);
	 void withdraw(double amount) throws MaximumWithdrawalsPerMonthException;
}
