package com.aurionpro.structural.adapter.model;

public class Biscuit implements IItems{

	private String name;
	private double price;
	
	
	
	public Biscuit(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	@Override
	public String getItemName() {
		return getName();
	}

	@Override
	public double getItemPrice() {
		return getPrice();
		
	}
	
}
