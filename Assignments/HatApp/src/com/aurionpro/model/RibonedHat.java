package com.aurionpro.model;

public class RibonedHat extends HatDecorater{

	public RibonedHat(IHat hat) {
		super(hat);
	}

	@Override
	public String getName() {
		return "Riboned Hat " + super.getName();
	}

	@Override
	public double getPrice() {
		return 3000 + super.getPrice();
	}

	@Override
	public String getDescription() {
		return "This is the riboned hat" + super.getDescription();
	}
	
	

}
