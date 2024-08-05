package com.aurionpro.test;

import java.util.Scanner;

public class MultiDimensionalArray {

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
		
		System.out.println("Matrix is ");
		//output
		for(int i=0; i< rows;i++) {
			for(int j=0;j<columns;j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
