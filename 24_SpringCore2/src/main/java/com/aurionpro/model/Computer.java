package com.aurionpro.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Computer {
	@Value("Apple")
	private String name;
	
	//objects are always injected
	@Autowired
	private Harddisk hardisk;
	
	public Computer() {
		System.out.println("default constructor of computer is called");
	}
	public Computer(String name, Harddisk hardisk) {
		super();
		this.name = name;
		this.hardisk = hardisk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Harddisk getHardisk() {
		return hardisk;
	}
	public void setHardisk(Harddisk hardisk) {
		this.hardisk = hardisk;
	}
	@Override
	public String toString() {
		return "Computer [name=" + name + ", hardisk=" + hardisk + "]";
	}
	
}

