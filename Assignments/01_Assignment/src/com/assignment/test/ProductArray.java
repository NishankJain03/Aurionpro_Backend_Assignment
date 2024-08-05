package com.assignment.test;

import java.util.Scanner;

public class ProductArray {
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int size = scanner.nextInt();
		int[] array = new int [size];
		System.out.println("Enter the elements");
		for(int i=0 ;i <size; i++) {
			array[i] = scanner.nextInt();
		}
        int[] result = productExceptSelf(array);
        for (int i : result) {
            System.out.print(i + " ");
        }

	}
	 public static int[] productExceptSelf(int[] nums) {
	        int n = nums.length;

	        int[] leftProducts = new int[n];
	        int[] rightProducts = new int[n];
	        int[] product = new int[n];

	        leftProducts[0] = 1;
	        for (int i = 1; i < n; i++) {
	            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
	        }

	        rightProducts[n - 1] = 1;
	        for (int i = n - 2; i >= 0; i--) {
	            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
	        }

	        for (int i = 0; i < n; i++) {
	            product[i] = leftProducts[i] * rightProducts[i];
	        }

	        return product;
	    }
}
