package com.assignment.test;

import java.util.Scanner;

public class ShiftCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the word");
		String word = scanner.next();
		
		System.out.println("Enter the shift ");
		int shift = scanner.nextInt();
		
		String newWord = "";
		
		for(int i=0; i< word.length(); i++) {
			char asciiValue = word.charAt(i);
			char newAsciiValue = asciiValue;
			
			if('A' <= asciiValue && asciiValue <= 'Z') {
				newAsciiValue = (char) ('A' + ((asciiValue - 'A' + shift + 26)% 26));
			} else if('a' <= asciiValue && asciiValue <= 'z') {
				newAsciiValue = (char) ('a' + ((asciiValue - 'a' + shift + 26)% 26));
			}
			newWord += newAsciiValue;
			
			
		}
		System.out.println(newWord);
	}

}
