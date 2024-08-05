package com.assignment.test;

import java.util.Scanner;

public class TreasureIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Choose the direction");
		String direction = scanner.next();
		
		if(direction == "left") {
			System.out.println("Choose the action");
			String action = scanner.next();
			if(action == "wait") {
				System.out.println("Choose the door");
				String door = scanner.next();
				switch(door) {
				case "red":
					System.out.println("Burned by fire Game over");
					break;
				case "blue":
					System.out.println("Eaten by beasts Game over");
					break;
				case "yellow" :
					System.out.println("You win");
					break;
				default:
					System.out.println("Game over");
					break;
				}
			} else {
				System.out.println("Attacked by trout Game over");
			}
		} else {
			System.out.println("Fall into the hole Game Over");
		}
		scanner.close();
		
	}

}
