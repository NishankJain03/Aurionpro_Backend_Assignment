package com.aurionpro.test;

import java.util.Scanner;

public class MaximumElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("Enter the size of the array");
		int size = scanner.nextInt();
		
		int array[] = new int[size];
		
		for(int i=0; i<size;i++) {
			System.out.println("Add the element");
			array[i] = scanner.nextInt();
		}
		int max = array[0];
		//output
		for(int i=0;i<size;i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		System.out.println("The maximum element in the array is " + max);
	}

}
