package com.assignment.test;

import java.util.Scanner;
 
public class ATMWithdrawal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter withdrawal amount");
		int amount = scanner.nextInt();
		
		if(amount > 50000) {
			System.out.println("Amount exceeds withdrawal limit of 50000");
		} else if(amount % 100 != 0) {
			System.out.println("Amount should be in multiple of 100");
		} else {
			int twoThousand = amount / 2000;
			amount %= 2000;
			
			int fiveHundred = amount / 500;
			amount %= 500;
			
			int twoHundred = amount / 200;
			amount %= 200;
			
			int hundreds = amount / 100;
			
			if(twoThousand > 0) {
				System.out.println("Two Thousand " + twoThousand);
			}
			if(fiveHundred > 0) {
				System.out.println("Five Hundred " + fiveHundred);
			}
			if(twoHundred > 0) {
				System.out.println("Two Hundred " + twoHundred);
			}
			if(hundreds > 0) {
				System.out.println("Hundred " + hundreds);
			}
 		}
		scanner.close();
		

	}

}
