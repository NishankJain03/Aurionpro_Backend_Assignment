package com.aurionpro.dip.solution;

public class DBLogger implements ILogger{

	@Override
	public void log(String err) {
		System.out.println("Logged to Database " + err);
		
	}
	
}
