package com.aurionpro.model;

public class HatAdapter implements IItems{
	Hat hat;
	
	
	public HatAdapter(Hat hat) {
		super();
		this.hat = hat;
	}
	
	

	public Hat getHat() {
		return hat;
	}



	public void setHat(Hat hat) {
		this.hat = hat;
	}



	@Override
	public String getItemName() {
		// TODO Auto-generated method stub
		return hat.getShortName()+hat.getLongName();
	}

	@Override
	public double getItemPrice() {
		// TODO Auto-generated method stub
		return hat.getBasicPrice()+hat.getTax();
	}



	@Override
	public String toString() {
		return "HatAdapter [hat=" + hat + "]";
	}
	

}
