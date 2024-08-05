package com.aurionpro.iterative.test;

import java.util.Scanner;

public class TableOfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		for(int i=1; i<= 10; i++) {
			for(int j = 1; j <= 10;j++) {
				System.out.print("\t" + j * i);
				
			}
			System.out.println();
		}
		

	}

}
