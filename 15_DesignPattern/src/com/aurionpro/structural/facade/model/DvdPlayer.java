package com.aurionpro.structural.facade.model;

public class DvdPlayer implements TurnOn{

	@Override
	public void On() {
		System.out.println("Dvd Player is turned On");
		
	}
	
	public void setMovie(String name) {
		System.out.println("Movie " + name + "Has been set");
	}
	
}
