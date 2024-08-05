package com.assignment.test;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.assignment.model.Player;

public class PlayerTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of players");
		int size = scanner.nextInt();
		Player players[] = new Player[size];
		
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
			
			players[i] = new Player(playerId, name, numberOfMatches, runs, numberOfWickets);
		}
		
		Player maxAveragePlayer = getMaxAveragePlayer(players);
//		if(maxAveragePlayer != null) {
//			System.out.println("Player with maximum average");
//			System.out.println(maxAveragePlayer.calculateAverage());
//		}else {
//			System.out.println("No player available");
//		}
//		
		//display in ascending	
		sortAscending(players);
		
		//display
		for(int i=0;i<players.length;i++) {
			System.out.println("PlayerId " +  players[i].getPlayerId());
			System.out.println("Name " + players[i].getName());
			System.out.println("Number of Matches Played " + players[i].getNumberOfMatches());
			System.out.println("Number of Wickets taken " + players[i].getNumberOfWickets());
			System.out.println("Runs Scored " + players[i].getRuns());
			System.out.println("Average "+ players[i].calculateAverage());
		}
		

	}
	
	

	public static Player getMaxAveragePlayer(Player players[]) {
		Player maxAveragePlayer = null;
		double maxAverage = Double.MIN_VALUE;
		
		for(int i=0; i<players.length; i++) {
			double average = players[i].calculateAverage();
			if(average > maxAverage) {
				maxAverage = average;
				maxAveragePlayer = players[i];
			}
		}
		return maxAveragePlayer;
		
	}
	public  static void sortAscending(Player []players) {
		for(int i=0;i<players.length-1;i++) {
			for(int j=0; j<players.length-i-1;j++) {
				if(players[j].calculateAverage() > players[j+1].calculateAverage()) {
					Player temp = players[j];
					players[j] = players[j+1];
					players[j+1] = temp;
				}
			}
		}
		
	}

}
