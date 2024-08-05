package com.assignment.test;

import java.util.Scanner;
 	
public class CurrencyDenomination {

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
			
			int hundred = amount / 100;
			
			if(twoThousand > 0) {
				System.out.println("We require " + twoThousand + " Two Thousand Rupees Note");
			}
			if(fiveHundred > 0) {
				System.out.println("We require " + fiveHundred + " Five Hundred Rupees Note");
			}
			if(twoHundred > 0) {
				System.out.println("We require " + twoHundred + " Two Hundred Rupees Note");
			}
			if(hundred > 0) {
				System.out.println("We require " + hundred + " One Hundred Rupees Note");
			}
 		}
		scanner.close();
		

	}

}
