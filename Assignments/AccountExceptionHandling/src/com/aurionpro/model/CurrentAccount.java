package com.aurionpro.model;
import com.aurionpro.exceptions.AccountException;;
public class CurrentAccount extends Account{
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
	    	if(amount <= 0) {
	    		throw new AccountException.AmountLessThanZero();
	    	}
	        setBalance(getBalance() + amount);
	        System.out.println("Amount credited successfully. New balance is " + getBalance());
	        return;
	    }
	    public void debit(double amount) {
	        double availableFunds = getBalance() + overDraftLimit;
	        if(amount > availableFunds)
	        	throw new AccountException.AmountGreaterThanOverDraftLimit();
	        canDebit(amount, availableFunds);      
	    }
	    public void canDebit(double amount, double availableFunds) {
	    	if(amount <= 0)
	    		throw new AccountException.AmountLessThanZero();
	        setBalance(getBalance() - amount);
	        System.out.println("Amount debited successfully. New balance is " + getBalance());
	        return;
	    }
}	
