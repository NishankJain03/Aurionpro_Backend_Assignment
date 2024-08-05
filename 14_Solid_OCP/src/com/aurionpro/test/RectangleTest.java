package com.aurionpro.test;

import com.aurionpro.model.Circle;
import com.aurionpro.model.Rectangle;
import com.aurionpro.model.Shape;

public class RectangleTest {

	public static void main(String[] args) {
		Shape shape;
		shape = new Rectangle(4, 7);
		System.out.println("Area of rectangle is " + shape.area());
		
		shape = new Circle(4);
		System.out.println("Area of the circle is " + shape.area());

	}

}
