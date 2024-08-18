package com.aurionpro.model;

public class Hardisk {
	private int capacity;

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		System.out.println("setter of the capacity of the hardisk is called");
		this.capacity = capacity;
	}

	public Hardisk() {
		System.out.println("Default constructor of the hardisk is called");
	}
	
	
	public Hardisk(int capacity) {
		super();
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Hardisk [capacity=" + capacity + "]";
	}
	
	
}
