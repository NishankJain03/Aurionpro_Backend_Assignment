package com.assignment.model;

public class Bank {
	private long accountNumber;
	private String name;
	private double balance;
	private AccountType accountType;
	
	public Bank(long accountNumber, String name, double balance, AccountType accountType) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		this.accountType = accountType;
	}
	
	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	
	public void credit(double amount) {
		if(amount > 0) {
			balance += amount;
			System.out.println("Amount credited successfully New balance is " + balance);
		}else {
			System.out.println("Enter valid value");
		}
	}
	
	public void debit(double amount) {
		if(amount > 0) {
			if(balance >= amount) {
				balance -= amount;
				System.out.println("Amount debited successfully New balance is " + balance);
			}else {
				System.out.println("Insufficient balance");
			}
		}else {
			System.out.println("Invalid amount");
		}
	}
	
	
	public static Bank getMaximumBalance(Bank accounts[]) {
		if(accounts == null || accounts.length == 0) {
			return null;
		}
		Bank maxBalanceAccount = accounts[0];
		for(int i=0; i<accounts.length; i++) {
			if(accounts[i].getBalance() > maxBalanceAccount.getBalance()) {
				maxBalanceAccount = accounts[i];
			}
		}
		
		return maxBalanceAccount;
	}
	
	public void displayDetails() {
		System.out.println("Account Number " + accountNumber);
		System.out.println("Name: "+ name);
		System.out.println("Balance " + balance);
		System.out.println("Account Type " + accountType);
	}
}
