package com.aurionpro.model;

public class SavingsAccount extends Account {
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
        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("Amount credited successfully. New balance is " + getBalance());
            return;
        } 
        System.out.println("Enter a valid value.");
    }

    public void debit(double amount) {
        if (amount > 0 && (getBalance() - amount >= minimumBalance)) {
            setBalance(getBalance() - amount);
            System.out.println("Amount debited successfully. New balance is " + getBalance());
            return;
        }
        System.out.println("Cannot withdraw. Minimum balance requirement not met or invalid amount.");
    }
}
