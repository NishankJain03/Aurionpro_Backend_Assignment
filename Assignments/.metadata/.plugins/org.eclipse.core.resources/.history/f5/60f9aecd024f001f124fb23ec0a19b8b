package com.aurionpro.model;
import com.aurionpro.exceptions.AccountException;
public class SavingsAccount extends Account{
	 private double minimumBalance;
	    public SavingsAccount(long accountNumber, String name, double balance, double minimumBalance) {
	        super(accountNumber, name, balance);
	        this.minimumBalance = minimumBalance;
	    }
	    public double getMinimumBalance() {
	        return minimumBalance;
	    }

	    public void setMinimumBalance(double minimumBalance) {
	        this.minimumBalance = minimumBalance;
	    }
	    @Override
	    public String toString() {
	        return "SavingsAccount [minimumBalance=" + minimumBalance + ", AccountNumber=" + getAccountNumber()
	                + ", Name=" + getName() + ", Balance=" + getBalance() + "]";
	    }
	    public void credit(double amount) {
	    	if(amount <= 0)
	    		throw new AccountException.AmountLessThanZero();
	        setBalance(getBalance() + amount);
	        System.out.println("Amount credited successfully. New balance is " + getBalance());
	        return;
	    }
	    public void debit(double amount) {
	    	if(amount <= 0)
	    		throw new AccountException.AmountLessThanZero();
	    	if(getBalance() - amount <= minimumBalance)
	    		throw new AccountException.MinimumBalanceNeedToMaintain();
	        setBalance(getBalance() - amount);
	        System.out.println("Amount debited successfully. New balance is " + getBalance());
	        return;
	    }
}
