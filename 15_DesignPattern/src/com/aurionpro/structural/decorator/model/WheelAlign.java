package com.aurionpro.structural.decorator.model;

public class WheelAlign extends CarServiceDecorator{

	public WheelAlign(ICarService carObj) {
		super(carObj);
	}

	@Override
	public double getCost() {
		return 500 + super.getCost();
	}
	
}
