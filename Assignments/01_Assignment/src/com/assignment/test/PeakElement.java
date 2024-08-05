package com.assignment.test;

import java.util.Scanner;

public class PeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		//taking the input
		System.out.println("Enter the size of the array");
		int size = scanner.nextInt();
		int array[] = new int[size];
		
		if(size == 0) {
			System.out.println("There is no such peak element");
			return;
		}
		
		System.out.println("Add the elements in the array in the sorted order");
		for(int i=0; i<size; i++) {
			array[i] = scanner.nextInt();
		}
		if(size == 1) {
			System.out.println("peak element is " + array[0]);
			return;
		}
		
		int []peakArray = new int[size];
		int peakCount = 0;
		
		
		
		//check the first element
		if(array[0] >= array[1]) {
			peakArray[peakCount] = array[0];
			peakCount++;
		}
		
		//check the middle element
		for(int i=1; i<size-1;i++) {
			if(array[i] >= array[i-1] && array[i] >= array[i+1]) {
				peakArray[peakCount] = array[i];
				peakCount++;
			}
		}
		
		//check the last element
		if(array[size - 1] >= array[size - 2]) {
			peakArray[peakCount] = array[size - 1];
			peakCount++;
		}
		
		System.out.println("Peak element are");
		for(int i=0;i<peakCount;i++) {
			System.out.println(peakArray[i]);
		}
		
		
	}

}
