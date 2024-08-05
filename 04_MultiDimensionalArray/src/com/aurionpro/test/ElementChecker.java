package com.aurionpro.test;	

import java.util.Scanner;

public class ElementChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the rows");
		int rows = scanner.nextInt();
		
		System.out.println("Enter the columns");
		int columns = scanner.nextInt();
		
		int matrix[][] = new int[rows][columns];
		
		System.out.println("Enter the elements");

		for(int i=0; i< rows;i++) {
			for(int j=0;j<columns;j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		
		System.out.println("Enter the element you want to search ");
		int targetNumber = scanner.nextInt();
		boolean flag = false;
		//searching the element
		for(int i=0; i< rows;i++) {
			for(int j=0;j<columns;j++) {
				if(matrix[i][j] == targetNumber) {
					flag =true;
					break;
				}
			}
		}
		
		if(flag) {
			System.out.println("Element is found");
		}else {
			System.out.println("Element is not found");
		}
	}

}
