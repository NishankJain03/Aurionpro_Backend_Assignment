package com.aurionpro.test;
import java.util.Scanner;

import com.aurionpro.model.Cricket;

public class CricketTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner scanner = new Scanner(System.in);
		Cricket players[] = new Cricket[3];
		
		for(int i=0 ;i< players.length; i++) {
			System.out.println("Enter the playerId");
			int playerId = scanner.nextInt();
			System.out.println("Enter your name");
			String name = scanner.next();
			System.out.println("Enter number of matches played");
			int numberOfMatches = scanner.nextInt();
			System.out.println("Enter runs scored");
			int runs = scanner.nextInt();
			System.out.println("Enter the number of wickets taken");
			int numberOfWickets = scanner.nextInt();
			
			players[i] = new Cricket(playerId, name, numberOfMatches, runs, numberOfWickets);
		}
		
		for(int i=0; i<players.length; i++) {
			players[i].display();
			players[i].calculateAverage();
		}
		
		
	}

}

//finalize method  in jdk 1.5 before deleting the object the finalize method is called
//this method performs closing acitvities 
//after this exceution the object is deleted
//to explicitly perform garbage collection we use System.gc();
//whenever we create a array of objects we write the name in the plural form

//we can create an array of objects
//
