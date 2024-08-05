package com.aurionpro.isp.solution.model;

public class Labour implements IWorker{

	@Override
	public void eat() {
		System.out.println("Labour is eating");
		
	}

	@Override
	public void drink() {
		System.out.println("Labour is drinking");
		
	}

	@Override
	public void start() {
		System.out.println("Labour has started the work");
		
	}

	@Override
	public void stop() {
		System.out.println("Labour has stopped the work");
		
	}
	
}
