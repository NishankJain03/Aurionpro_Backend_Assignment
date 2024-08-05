package com.aurionpo.abstractFactory.model;

public class CurrentAccount implements IAccount{
	private long accountNumber;
	private String name;
	private double balance;
	private double overDraftLimit;
	
	public CurrentAccount(long accountNumber, String name, double balance, double overDraftLimit) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		this.overDraftLimit = overDraftLimit;
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


	public double getOverDraftLimit() {
		return overDraftLimit;
	}


	public void setOverDraftLimit(double overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
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
		double availableFunds = getBalance() + overDraftLimit;
        if(amount > availableFunds) {
    		System.out.println("Amount greater than over draft limit set");
    		return;
    	}
        canDebit(amount, availableFunds);
		
	}
	public void canDebit(double amount, double availableFunds) {
    	if (amount > 0 && amount <= availableFunds) {
            setBalance(getBalance() - amount);
            System.out.println("Amount debited successfully. New balance is " + getBalance());
            return;
        }
        System.out.println("Invalid amount.");
    }

	
}
