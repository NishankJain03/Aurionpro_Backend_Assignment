package com.aurionpro.isp.solution.model;

public class Worker implements IWorkable{

	@Override
	public void start() {
		System.out.println("Robot has started the work");
		
	}

	@Override
	public void stop() {
		System.out.println("Robot has stopped the work");
		
	}
	
}
