package com.aurionpro.test;
import java.util.Scanner;

import com.aurionpro.exceptions.AccountException.AmountGreaterThanOverDraftLimit;
import com.aurionpro.exceptions.AccountException.AmountLessThanZero;
import com.aurionpro.exceptions.AccountException.MinimumBalanceNeedToMaintain;
import com.aurionpro.exceptions.AccountException.MinimumBalanceToKeep;
import com.aurionpro.model.CurrentAccount;
import com.aurionpro.model.SavingsAccount;
public class AccountTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        CurrentAccount currentAccount = null;
        SavingsAccount savingsAccount = null;
        System.out.println("Welcome to the ATM");
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter initial balance: ");
        double balance = scanner.nextDouble();

        long accountNumber = (long) (Math.random() * Math.pow(10, 10));

        System.out.println("Choose Account Type: ");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int accountType = scanner.nextInt();
        
        switch(accountType) {
        case 1:
        	if (balance < 5000) {
                try {
                    throw new MinimumBalanceToKeep();
                } catch (MinimumBalanceToKeep e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }
        	savingsAccount = new SavingsAccount(accountNumber, name, balance, 5000);
            System.out.println("Savings Account created successfully.");
            break;
        case 2:
        	currentAccount = new CurrentAccount(accountNumber, name, balance, 50000);
            System.out.println("Current Account created successfully.");
            break;
        default:
        	 System.out.println("Invalid account type selected.");
        	 return;
        }
        while (true) {
            System.out.println("\nATM Menu");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.println("Please Choose an option");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    if (savingsAccount != null) {
                        System.out.println("The current balance for account number " + savingsAccount.getAccountNumber()+  " is $ " + savingsAccount.getBalance());
                    } 
                    if (currentAccount != null) {
                        System.out.println("Your current balance for account number " + currentAccount.getAccountNumber() + " is $ " + currentAccount.getBalance());
                    }
                    break;
                case 2:
                	try {
                    System.out.println("Enter the amount to deposit ");
                    double depositAmt = scanner.nextDouble();
                    if (savingsAccount != null) {
                        savingsAccount.credit(depositAmt);
                    } 
                    if (currentAccount != null) {
                        currentAccount.credit(depositAmt);
                    }
                	}catch(AmountLessThanZero e) {
                		System.out.println(e.getMessage());
                	}
                    break;
                case 3:
                    System.out.println("Enter the amount to withdraw ");
                    try {
                    	double withdrawAmt = scanner.nextDouble();
                    	if (savingsAccount != null) {
                    		savingsAccount.debit(withdrawAmt);
                    	}
                    	if (currentAccount != null) {
                    		currentAccount.debit(withdrawAmt);
                    	}
                    }catch (AmountGreaterThanOverDraftLimit e) {
                    	System.out.println(e.getMessage());
                    }catch (AmountLessThanZero e) {
                    	System.out.println(e.getMessage());
                    }catch (MinimumBalanceNeedToMaintain e) {
                    	System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye.");
                    return;
                default:
                    System.out.println("Invalid option, Please Select Correct Option");
            }
        }

	}

}
