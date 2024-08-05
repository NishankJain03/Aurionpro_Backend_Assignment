package com.aurionpro.model;

public class ShapeClient {
	private Shape shapePrototype;

	//This prototype is used to create new shapes.
	public ShapeClient(Shape shapePrototype) {
		super();
		this.shapePrototype = shapePrototype;
	}
	
	public Shape createShape() {
		return shapePrototype.clone();
	}
}	
