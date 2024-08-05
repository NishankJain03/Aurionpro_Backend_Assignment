package com.aurionpro.model;

public class Box {
	private int width;
	private int height;
	private int depth;
	
	public Box() {
		this.width = 10;
		this.height = 20;
		this.depth = 10;
	}
	
	public Box(int width, int depth, int height) {
		this.width = width;
		this.height = depth;
		this.depth = height;
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
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public int getDepth() {
		return this.depth;
	}
	
	
	
}


//the class contains the blueprint of the object it contains the data members and member methods
//they define the what object should contain and how it should behave 
//memory is not assigned to the class it is assigned to the object
//whenever we assign do not assign access modifier it is bydefault set to defualt --> like public
//here in default it is accessible within the same package

//if we write Box box --> here box refers to null''
//abstraction --> hiding the impementation
//encapsulation --> hiding the data
//getter and setter ->. access each indivdual properties of the class

// this refers to the current object
// it refers to the object that has recently called the constructor or method
