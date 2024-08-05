package com.aurionpro.test;

import java.util.Scanner;

public class MatrixTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int matrix[][] = new int[3][3];
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the elements of the matrix");
		createRow(matrix, scanner);
		
		System.out.println("Matrix is ");
		printMatrix(matrix);
		

	}
	
	private static void readRowsElement(int matrix[][], Scanner scanner, int row) {
		for(int j=0; j<3;j++) {
			matrix[row][j] = scanner.nextInt();
		}
	}
	
	private static void createRow(int matrix[][], Scanner scanner) {
		for(int i=0; i<3;i++) {
			readRowsElement(matrix, scanner, i);
		}
	}
	
	private static void printRowsElement(int matrix[][], int row) {
		for(int j=0; j<3;j++) {
			System.out.print(matrix[row][j]);
		}
	}
	
	private static void printMatrix(int matrix[][]) {
		for(int i=0; i<3;i++) {
			printRowsElement(matrix, i);
			System.out.println("");
		}
	}

}


// object Calesthenics ruke 1 is there should be only one indentation there should not be more than one for loop or nested loop
// if nested loop use them in different method	
