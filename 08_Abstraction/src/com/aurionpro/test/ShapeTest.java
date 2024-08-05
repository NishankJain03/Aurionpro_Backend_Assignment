package com.aurionpro.test;

import com.aurionpro.model.Circle;
import com.aurionpro.model.Rectangle;
import com.aurionpro.model.Shape;
import com.aurionpro.model.Triangle;

public class ShapeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Shape shape;
		shape = new Circle(12);
		shape.area();
		
		shape = new Rectangle(12, 13);
		shape.area();
		
		shape = new Triangle(12,13);
		shape.area();
	}

}

//whenever we declared any methods as abstract we are making compulsion in the method overriding
//if we want that subclass also not giving the definition to abstract method we can make method also abstract 
//if we write final keyword for a method means that subclass will not inherit the method of the super class
//in order to stop inheritance we can defined class as final 
// if class -> final -> not inherit
// if method -> final -> not overridden
// if variable -> final -> treat as const

//abstract achieve partial abstraction and cannot use multiple inhertiance
