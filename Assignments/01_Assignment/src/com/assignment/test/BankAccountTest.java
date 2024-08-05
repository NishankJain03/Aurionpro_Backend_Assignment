package com.assignment.test;

import java.util.Random;
import java.util.Scanner;
import com.assignment.model.BankAccount;

public class BankAccountTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		BankAccount bankAccount = new BankAccount();
		long randomNumber = (long) (Math.random() * Math.pow(10, 10));
		bankAccount.setAccountNumber(randomNumber);
		
		System.out.println("Enter your name");
		String name = scanner.next();
		
		System.out.println("Enter your balance");
		double balance = scanner.nextDouble();
		bankAccount.setBalance(balance);
        
        boolean exit = false;
        while(!exit) {
        	System.out.println("ATM Menu");
        	System.out.println("1. Check Balance");
        	System.out.println("2. Deposit Money");
        	System.out.println("3. Withdraw Money");
        	System.out.println("4. Account Number");
        	System.out.println("5. Exit");
        	System.out.println("Choose Options");
        	
        	int choice = scanner.nextInt();
        	
        	switch (choice) {
        	case 1:
        		System.out.println("Current balance " + bankAccount.getBalance());
        		break;
        	case 2:
        		System.out.println("Enter the amount to deposit");
        		double depositAmount = scanner.nextDouble();
        		bankAccount.depositAmount(depositAmount);
        		break;
        	case 3:
        		System.out.println("Enter the amount to withdraw");
        		double withdrawMoney = scanner.nextDouble();
        		bankAccount.withdrawMoney(withdrawMoney);
        		break;
        	case 4:
        		System.out.println("Your Account Number " + bankAccount.getAccountNumber());
        		break;
        	case 5:
        		exit = true;
        		System.out.println("Exiting");
        		break;
        	default:
        		System.out.println("Please choose valid option");
        	}
        	
        	
        	
        }
        
       
        
        
		

	}

}
