package com.assignment.test;

import java.util.Scanner;

public class SecondLargest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int size = scanner.nextInt();
		int[] array = new int [size];
		System.out.println("Enter the elements");
		for(int i=0 ;i <size; i++) {
			array[i] = scanner.nextInt();
		}	
		int secondLargest = findSecondLargest(array);
		System.out.println("The second largest element is " + secondLargest);
	}
	private static int findSecondLargest(int[] array) {
		if(array == null || array.length < 2)
			return 0;
		int firstLargest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		
		for(int element: array ) {
			if(element > firstLargest) {
				secondLargest = firstLargest;
				firstLargest = element;
			}else if(element > secondLargest && element < firstLargest) {
				secondLargest = element;
			}
		}
		return secondLargest;	
	}
}
