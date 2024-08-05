package com.aurionpo.abstractFactory.model;

public class Mahindra implements ICar{

	@Override
	public void start() {
		System.out.println("Mahindra has started");
		
	}

	@Override
	public void stop() {
		System.out.println("Mahindra has stopped");
		
	}
	
}
