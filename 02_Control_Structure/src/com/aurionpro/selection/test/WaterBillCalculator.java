package com.aurionpro.selection.test;

import java.util.Scanner;

public class WaterBillCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of units consumed");
		int unitsConsumed = sc.nextInt();
		
		int meterCharge = 75;
		int charge = 0;
		if(unitsConsumed <= 100) {
			charge = unitsConsumed * 5;
		}else if(unitsConsumed <= 250) {
			charge = unitsConsumed * 10;
		}else {
			charge = unitsConsumed * 20;
		}
		
		int totalBill = charge + meterCharge;
		System.out.println("Total Water Bill is " + totalBill);
		
		sc.close();
		

	}

}
