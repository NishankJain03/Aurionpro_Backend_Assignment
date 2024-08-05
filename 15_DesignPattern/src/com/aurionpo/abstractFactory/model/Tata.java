package com.aurionpo.abstractFactory.model;

public class Tata implements ICar{

	@Override
	public void start() {
		System.out.println("Tata has started");
		
	}

	@Override
	public void stop() {
		System.out.println("Tata has stopped");
		
	}
	
}
