package com.aurionpro.structural.adapter.model;

public class HatAdapter implements IItems {
	private Hat hat;

	public HatAdapter(Hat hat) {
		this.hat  = hat;
	}
	@Override
	public String getItemName() {
		// TODO Auto-generated method stub
		return hat.getShortName() + hat.getLongName();
	}

	@Override
	public double getItemPrice() {
		// TODO Auto-generated method stub
		return hat.getBasePrice() + hat.getTax();
	}
	
}
