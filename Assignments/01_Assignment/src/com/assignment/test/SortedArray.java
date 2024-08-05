package com.assignment.test;

import java.util.Scanner;

public class SortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		//taking the input
		System.out.println("Enter the size of the array");
		int size = scanner.nextInt();
		int sortedArr[] = new int[size];
		
		System.out.println("Add the elements in the array in the sorted order");
		for(int i=0; i<size; i++) {
			sortedArr[i] = scanner.nextInt();
		}
		
		
		//square of the input array elements
		for(int i=0; i<size;i++) {
			sortedArr[i] = (int)Math.pow(sortedArr[i], 2);
		}
		
		int result[] = new int[sortedArr.length];
		int left = 0;
		int right = sortedArr.length - 1;
		int index = sortedArr.length - 1;
		while(left <= right) {
			if(sortedArr[left] > sortedArr[right]) {
				result[index] = sortedArr[left];
				index--;
				left++;
			}else {
				result[index] = sortedArr[right];
				index--;
				right--;
			}
		}
		
		System.out.println("The square of the element in the sorted order are ");
		//printing the output
		for(int i=0; i<size; i++) {
			System.out.print(result[i]+ " ");
		}
		
		scanner.close();
	}
	

}
