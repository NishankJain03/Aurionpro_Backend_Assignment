package com.aurionpro.test;

import java.util.Scanner;

public class SortElement {

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
		//output
		for(int i=0;i<size;i++) {
			for(int j=i+1;j<size;j++) {
				if(array[i] > array[j] ) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
//		int start = 0;
//		int end = array.length -1;
//		
//		while(start <= end) {
//			if(array[start] > array[end] ) {
//				int temp = array[start];
//				array[start] = array[end];
//				array[end] = temp;
//				start++;
//				end--;
//			}else {
//				start++;
//			}
//		}
		
		for(int i=0;i<size;i++) {
			System.out.print(array[i]);
		}

	}

}
