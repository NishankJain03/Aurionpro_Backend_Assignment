package com.assignment.test;

import java.util.Scanner;
import java.util.Random;

public class PigGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int totalScore = 0;
		int turnScore;
		int turnCount = 0;
		
		System.out.println("Let's Play");
		
		while(totalScore < 20) {
			turnCount++;
			turnScore = 0;
			boolean turnOver = false;
			
			System.out.println("\nTURN " + turnCount);
			while(!turnOver) {
				System.out.println("Roll or hold ? (r/h): ");
				char choice = scanner.next().charAt(0);
				
				if(choice == 'r') {
					int die = random.nextInt(6) + 1;
					System.out.println("Die " + die);
					
					if(die == 1) {
						System.out.println("Score turns to zero");
						turnOver = true;
						turnScore = 0;
					} else {
						turnScore += die;
						if(turnScore > 20) {
							totalScore += turnScore;
							System.out.println("Score for turn " + turnScore);
							System.out.println("Total score " + totalScore);
							turnOver = true;
						}
					}
				} else if(choice == 'h') {
					totalScore += turnScore;
					System.out.println("Score for turn " + turnScore);
					System.out.println("Total score " + totalScore);
					turnOver = true;
					if(totalScore >= 20) {
						System.out.println("You Won");
						
					}
				} else {
					System.out.println("Invalid input");
				}
			}
		}
		System.out.println("You have finished in " + turnCount + "turns");
		scanner.close();

	}

}
