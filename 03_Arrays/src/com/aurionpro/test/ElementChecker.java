package com.aurionpro.test;

import java.util.Scanner;

public class ElementChecker {

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
		System.out.println("Enter the element you want to find in the array");
		int targetElement = scanner.nextInt();
		//output
		boolean flag = false;
		for(int i=0;i<size;i++) {
			if(array[i] == targetElement) {
				flag = true;
				break;
			}
		}
		if(flag) {
			System.out.println("Element is found");
		}else {
			System.out.println("Element is not found");
		}
		
		
	}

}
