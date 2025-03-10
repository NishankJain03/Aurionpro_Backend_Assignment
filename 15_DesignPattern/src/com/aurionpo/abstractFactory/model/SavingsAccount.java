package com.aurionpo.abstractFactory.model;

public class SavingsAccount implements IAccount{
	private long accountNumber;
	private String name;
	private double balance;
	private double minimumBalance;

	public SavingsAccount(long accountNumber, String name, double balance, double minimumBalance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		this.minimumBalance = minimumBalance;
	}

	
	
	public long getAccountNumber() {
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



	public double getMinimumBalance() {
		return minimumBalance;
	}



	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}



	@Override
	public void credit(double amount) {
		if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("Amount credited successfully. New balance is " + getBalance());
            return;
        } 
        System.out.println("Enter a valid value.");
		
	}

	@Override
	public void debit(double amount) {
		if (amount > 0 && (getBalance() - amount >= minimumBalance)) {
            setBalance(getBalance() - amount);
            System.out.println("Amount debited successfully. New balance is " + getBalance());
            return;
        }
        System.out.println("Cannot withdraw. Minimum balance requirement not met or invalid amount.");
		
	}

	
}
