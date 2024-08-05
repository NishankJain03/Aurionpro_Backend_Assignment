package com.aurionpro.model;

public class Rectangle implements Shape{
	private String color;
	
	
	public Rectangle(String color) {
		super();
		this.color = color;
	}

	@Override
	public Rectangle clone() {
		try {
			return (Rectangle) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			throw new AssertionError();
		}
	}
	
	@Override
	public void draw() {
		System.out.println("Drawing a " + color + " rectangle");
		
	}
	
}
