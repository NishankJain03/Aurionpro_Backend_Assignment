package com.aurionpro.model;

public interface Shape {
	void area();
	
	//first way to define the method
	default void volume() {
		System.out.println("This is the default volume of the shape");
	}
	
	//another way to define the method
	static void perimeter() {
		System.out.println("This is the perimeter of the shape");
	}
	
}
