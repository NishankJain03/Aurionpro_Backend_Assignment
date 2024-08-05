package com.aurionpro.model;

public class Cricket {
	private int playerId;
	private String name;
	private int numberOfMatches;
	private int runs;
	private int numberOfWickets;

	public Cricket(){
		this.playerId  = 7060;
		this.name = "Nishank";
		this.numberOfMatches = 10;
		this.runs = 900;
		this.numberOfWickets = 10;
	}
	
	public Cricket(int playerId, String name, int numberOfMatches, int runs, int numberOfWickets){
		this.playerId = playerId;
		this.name = name;
		this.numberOfMatches = numberOfMatches;
		this.runs = runs;
		this.numberOfWickets = numberOfWickets;
	}

	public int getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfMatches() {
		return this.numberOfMatches;
	}

	public void setNumberOfMatches(int numberOfMatches) {
		this.numberOfMatches = numberOfMatches;
	}

	public int getRuns() {
		return this.runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getNumberOfWickets() {
		return this.numberOfWickets;
	}

	public void setNumberOfWickets(int numberOfWickets) {
		this.numberOfWickets = numberOfWickets;
	}
	
	public void display() {
		System.out.println("PlayerID is " + this.playerId);
		System.out.println("Name is " + this.name);
		System.out.println("Number of Matches Played is " + this.numberOfMatches);
		System.out.println("Runs Scored is " + this.runs);
		System.out.println("Number of Wickets taken is " + this.numberOfWickets);
		
	}
	
	public void calculateAverage() {
		double average = this.runs / this.numberOfMatches;
		System.out.println("Average is " + average);
	}
	
}
