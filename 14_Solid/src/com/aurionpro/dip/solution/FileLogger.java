package com.aurionpro.dip.solution;

public class FileLogger implements ILogger{

	@Override
	public void log(String err) {
		System.out.println("Logged to File" + err);
		
	}
	
}
