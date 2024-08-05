package com.aurionpro.selection.test;

import java.util.Scanner;

public class SeasonChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Number of Month");
		int numberOfMonth = sc.nextInt();
		
		switch(numberOfMonth) {
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("Summer Season");
			break;
		case 6:
		case 7:
		case 8:
		case 9:
			System.out.println("Rainy Season");
			break;
		case 1:
		case 10:
		case 11:
		case 12:
			System.out.println("Winter Season");
			break;
		default:
			System.out.println("Please Enter correct number of month");
		}

	}

}
