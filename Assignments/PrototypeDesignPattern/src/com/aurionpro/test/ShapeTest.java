package com.aurionpro.test;


import com.aurionpro.model.Rectangle;
import com.aurionpro.model.Circle;
import com.aurionpro.model.Shape;
import com.aurionpro.model.ShapeClient;

public class ShapeTest {

	public static void main(String[] args) {
		//concrete prototype
		Shape circlePrototype = new Circle("red");
		Shape rectanglePrototype = new Rectangle("blue");
		
		// to create new circle shapes.
		ShapeClient circleClient = new ShapeClient(circlePrototype);
		ShapeClient rectangleClient = new ShapeClient(rectanglePrototype);
		
		//using the prototype
		Shape redCircle = circleClient.createShape();
		Shape blueRectangle = rectangleClient.createShape();
		
		redCircle.draw();
		blueRectangle.draw();
		

	}

}
//the concept is to copy an existing object rather than creating a new instance from scratch because creating new object may be costly
//this approach save costly resources and time especially when object creation is a heavy process