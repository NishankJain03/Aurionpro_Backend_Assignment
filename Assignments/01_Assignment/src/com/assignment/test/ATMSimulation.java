package com.assignment.test;

import java.util.Scanner;

public class ATMSimulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the balance ");
		double balance = scanner.nextDouble();
		
		while(true) {
			System.out.println("\nATM Menu");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdraw Money");
			System.out.println("4. Exit");
			System.out.println("Please Choose option");
			
			int option = scanner.nextInt();
			switch(option) {
			case 1:
				System.out.println("Your current balance is $ " + balance);
				break;
			case 2:
				System.out.println("Enter the amount to deposit ");
				double depositAmt = scanner.nextDouble();
				
				balance += depositAmt;
				System.out.println("You have deposited " + depositAmt + " $. " + "Your new balance is " + balance);
				break;
			case 3:
				System.out.println("Enter the amount to withdraw ");
				double withdrawAmt = scanner.nextDouble();
				if(withdrawAmt > balance) {
					System.out.println("Cannot withdraw the money");
					break;
				}
				
				balance -= withdrawAmt;
				System.out.println("You have deposited " + withdrawAmt + " $. " + "Your new balance is " + balance);
				break;
			case 4:
				System.out.println("Thankyou for using ATM. Goodbye");
				return;
			default:
				System.out.println("Invalid option, Please Select Correct Option");
			}
			
			
		}
		
		
	}

}
