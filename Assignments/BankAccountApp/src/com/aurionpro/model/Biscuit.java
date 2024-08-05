package com.aurionpro.model;

public class Biscuit implements IItems{
	private String name;
	private double mrp;
	public Biscuit(String name, double mrp) {
		super();
		this.name = name;
		this.mrp = mrp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMrp() {
		return mrp;
	}
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
	@Override
	public String getItemName() {
		// TODO Auto-generated method stub
		return getName();
	}
	@Override
	public double getItemPrice() {
		// TODO Auto-generated method stub
		return getMrp();
	}
	@Override
	public String toString() {
		return "Biscuit [name=" + name + ", mrp=" + mrp + "]";
	}
	
	
}
