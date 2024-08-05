package com.aurionpro.model;

import com.aurionpro.exception.InsufficientBalanceException;

public class Account {
	private int accountNumber;
	private String name;
	private double balance;
	public Account(int accountNumber, String name, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + "]";
	}

	public void credit(double amount) {
		if(amount > 0) {
			balance += amount;
			System.out.println("Amount credited successfully New balance is " + balance);
			return;
		}
			System.out.println("Enter valid value");
	}
	
	public void debit(double amount) {
		
		if(amount > balance)
			throw new InsufficientBalanceException(amount);
		if(amount > 0) {
			if(balance >= amount) {
				balance -= amount;
				System.out.println("Amount debited successfully New balance is " + balance);
				return;
			}
		}
			System.out.println("Invalid amount");
	}
}
