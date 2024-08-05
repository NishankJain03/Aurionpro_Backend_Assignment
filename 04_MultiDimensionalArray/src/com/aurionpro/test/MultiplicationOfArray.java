package com.aurionpro.test;

import java.util.Scanner;

public class MultiplicationOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the number of rows");
		int rows1 = scanner.nextInt();
		
		System.out.println("Enter the number of columns");
		int col1 = scanner.nextInt();
		
		int matrix1[][] = readMatrix(rows1, col1);
		
		System.out.println("Enter the number of rows of second matrix");
		int row2= scanner.nextInt();
		
		System.out.println("Enter the number of columns second matrix");
		int col2= scanner.nextInt();
		
		int matrix2[][] = readMatrix(row2, col2);
		
		if(col1 != row2) {
			System.out.println("Matrix multiplication is not possible");
			return;
		}
		
		int matrixProduct[][] = new int[rows1][col2];
		for(int i=0 ;i< rows1; i++) {
			processColumn(col2, i, matrixProduct, matrix1, matrix2, col1);
		}
		printMatrix(matrixProduct);

	}
	public static int[][] readMatrix(int rows, int columns){
		Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[rows][columns];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
	}
	public static void printMatrix(int[][] matrix3) {
        System.out.println("The Product of matrix is:");
        for (int i = 0; i < matrix3.length; i++) {
            for (int j = 0; j < matrix3[0].length; j++) {
                System.out.print(matrix3[i][j] + " ");
            }
            System.out.println();
        }
    }
	private static void processColumn(int col2, int i, int [][]matrixProduct, int [][]matrix1, int [][]matrix2, int col1) {
		for(int j=0;j<col2;j++) {
			productElement(col1, matrixProduct, matrix1, matrix2, i, j);
		}
	}
	private static void productElement(int col1, int [][]matrixProduct, int [][]matrix1, int [][]matrix2, int i, int j) {
		for(int k=0;k<col1;k++) {
			matrixProduct[i][j] += matrix1[i][k] * matrix2[k][j];
		}
	}

}
