package com.aurionpro.model;

public class CurrentAccount extends Account {
    private double overDraftLimit;

    public CurrentAccount(long accountNumber, String name, double balance, double overDraftLimit) {
        super(accountNumber, name, balance);
        this.overDraftLimit = overDraftLimit;
    }
    @Override
    public double getBalance() {
        return super.getBalance();
    }
    @Override
    public String toString() {
        return "CurrentAccount [overDraftLimit=" + overDraftLimit + ", AccountNumber=" + getAccountNumber()
                + ", Name=" + getName() + ", Balance=" + getBalance() + "]";
    }
    public double getOverDraftLimit() {
        return overDraftLimit;
    }
    public void setOverDraftLimit(double overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }
    public void credit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("Amount credited successfully. New balance is " + getBalance());
            return;
        } 
        System.out.println("Enter a valid value.");
    }
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
