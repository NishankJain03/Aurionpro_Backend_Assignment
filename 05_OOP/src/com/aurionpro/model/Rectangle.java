package com.aurionpro.model;

public class Rectangle {
	private int width;
	private int height;
	
	public Rectangle() {
		this.width = 10;
		this.height = 10;
	}
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	public int getWidth() {
		return this.width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void area(int height, int width) {
		System.out.println("Area is " + this.height * this.width);
	}
	public void area() {
		System.out.println("Area is " + this.height * this.width);
	}
}
