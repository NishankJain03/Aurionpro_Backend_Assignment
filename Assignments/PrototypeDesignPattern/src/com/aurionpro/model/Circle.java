package com.aurionpro.model;

public class Circle implements Shape{
	private String color;
	
	//constructor to set the color
	public Circle(String color) {
		this.color = color;
	}
	
	@Override
	public Circle clone()  {
		try {
			return (Circle) super.clone();  // create a shallow copy of the Circle object
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

	@Override
	public void draw() {
		System.out.println("Drawing a " + color + " circle");
		
	}
}
