package com.aurionpo.abstractFactory.model;

public class MarutiFactory implements ICarFactory{

	@Override
	public ICar makeCar() {
		return new Maruti();	
	}
	
}
