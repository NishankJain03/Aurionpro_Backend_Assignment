package com.aurionpro.test;

import java.util.Scanner;

public class SumOfMatrices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the number of rows");
		int rows= scanner.nextInt();
		
		System.out.println("Enter the number of columns");
		int columns= scanner.nextInt();
		
		int matrix1[][] = readMatrix(rows, columns);
		
		System.out.println("Enter the number of rows");
		int newRows= scanner.nextInt();
		
		System.out.println("Enter the number of columns");
		int newColumns= scanner.nextInt();
		
		int matrix2[][] = readMatrix(newRows, newColumns);
		
		
		int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;
        
        int matrix3[][] = new int[rows][columns];
 
        if(rows1 == rows2 && cols1 == cols2) {
        	for(int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                	matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
        }
        if(rows1 == rows2 && cols1 == cols2) {
        	 printMatrix(matrix3);
        }else {
        	System.out.println("Both have different rows and columsn");
        }
       
		
		

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
        System.out.println("The matrix is:");
        for (int i = 0; i < matrix3.length; i++) {
            for (int j = 0; j < matrix3[0].length; j++) {
                System.out.print(matrix3[i][j] + " ");
            }
            System.out.println();
        }
    }

}
