package com.aurionpro.model;

public class Circle implements Shape{
	private int radius;
	
	public Circle(int radius) {
		super();
		this.radius = radius;
	}
	@Override
	public void area() {
		System.out.println("Area of the circle is " + (3.14*radius*radius));
	}
	
	@Override
	public void volume() {
		System.out.println("This is the volume of the circle");
	}
	
	
	
}
