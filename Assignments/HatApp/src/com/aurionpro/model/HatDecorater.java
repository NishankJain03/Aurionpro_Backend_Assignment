package com.aurionpro.model;

public abstract class HatDecorater implements IHat{
	private IHat hat;
	
	public HatDecorater(IHat hat) {
		this.hat = hat;
	}

	@Override
	public String getName() {
		return hat.getName();
	}

	@Override
	public double getPrice() {
		return hat.getPrice();
	}

	@Override
	public String getDescription() {
		return hat.getDescription();
	}

}
