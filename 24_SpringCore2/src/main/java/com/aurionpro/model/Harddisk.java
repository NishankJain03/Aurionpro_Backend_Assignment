package com.aurionpro.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Harddisk {
	//we can set the default value by annotation 
	@Value("10")
	private int capacity;

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		System.out.println("setter of the capacity of the hardisk is called");
		this.capacity = capacity;
	}

	public Harddisk() {
		System.out.println("Default constructor of the hardisk is called");
	}
	
	
	public Harddisk(int capacity) {
		super();
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Harddisk [capacity=" + capacity + "]";
	}

	
	
	
}
