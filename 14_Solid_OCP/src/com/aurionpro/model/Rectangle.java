package com.aurionpro.model;

public class Rectangle implements Shape{
	private int height;
	private int width;
	public Rectangle(int height, int width) {
		super();
		this.height = height;
		this.width = width;
	}
	@Override
	public double area() {
		return width * height;
	}
}
