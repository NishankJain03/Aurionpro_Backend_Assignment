package com.aurionpro.model;

public class Circle implements Shape{
	private int radius;
	
	public Circle(int radius) {
		super();
		this.radius = radius;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 3.14 * radius * radius;
	}
	
}
