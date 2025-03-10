package com.aurionpro.abstractFactory.test;

import java.util.Scanner;

import com.aurionpo.abstractFactory.model.CurrentAccountFactory;
import com.aurionpo.abstractFactory.model.IAccount;
import com.aurionpo.abstractFactory.model.IAccountFactory;
import com.aurionpo.abstractFactory.model.SavingsAccount;
import com.aurionpo.abstractFactory.model.SavingsAccountFactory;

public class AccountTest {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        IAccountFactory savingsAccountFactory = new SavingsAccountFactory();
	        IAccountFactory currentAccountFactory = new CurrentAccountFactory();
	        
	        IAccount savings = null;
	        IAccount current = null;

	        System.out.println("Welcome to the ATM");
	        System.out.println("Choose Account Type: ");
	        System.out.println("1. Savings Account");
	        System.out.println("2. Current Account");
	        int accountType = scanner.nextInt();
	        
	        switch(accountType) {
	        case 1:
	        	savings = savingsAccountFactory.makeAccount(scanner);
	        	if(savings.getBalance() < 5000) {
	        		System.out.println("Minimum balance should be 5000");
	        		return;
	        	}
	            System.out.println("Savings Account created successfully.");
	            break;
	        case 2:
	        	current = currentAccountFactory.makeAccount(scanner);
	            System.out.println("Current Account created successfully.");
	            break;
	        default:
	        	 System.out.println("Invalid account type selected.");
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
	                    if (savings != null) {
	                        System.out.println("The current balance "+  "is $ " + savings.getBalance());
	                    } 
	                    if (current != null) {
	                        System.out.println("Your current balance f" +" is $ " + current.getBalance());
	                    }
	                    break;
	                case 2:
	                    System.out.println("Enter the amount to deposit ");
	                    double depositAmt = scanner.nextDouble();
	                    if (savings != null) {
	                    	savings.credit(depositAmt);
	                    } 
	                    if (current != null) {
	                    	current.credit(depositAmt);
	                    }
	                    break;
	                case 3:
	                    System.out.println("Enter the amount to withdraw ");
	                    double withdrawAmt = scanner.nextDouble();
	                    if (savings != null) {
	                    	savings.debit(withdrawAmt);
	                    }
	                    if (current != null) {
	                    	current.debit(withdrawAmt);
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
