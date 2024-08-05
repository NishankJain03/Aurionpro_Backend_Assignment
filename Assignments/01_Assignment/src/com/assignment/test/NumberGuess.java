package com.assignment.test;

import java.util.Scanner;
import java.util.Random;

public class NumberGuess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		String wantToPlay = "yes";
		while(wantToPlay.equalsIgnoreCase("yes")) {
			int targetNumber = random.nextInt(100) + 1;
			int attempts = 0;	
			boolean hasWon = false;
			
			System.out.println("Random number generated");
			while(!hasWon) {
				System.out.println("Guess a number");
				int guess = scanner.nextInt();
				attempts++;
				
				if(guess < targetNumber) {
					System.out.println("Sorry, too low");
				}else if(guess > targetNumber) {
					System.out.println("Sorry, too high");
				}else {
					System.out.println("You have won and you took " + attempts + " attempts" );
					hasWon = true;
				}
			}
			System.out.println("Do you want to play again");
			wantToPlay = scanner.next();
		}
		System.out.println("Thankyou for playing");
		scanner.close();
		

	}

}
