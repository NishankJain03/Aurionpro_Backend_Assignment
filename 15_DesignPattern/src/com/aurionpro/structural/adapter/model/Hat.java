package com.aurionpro.structural.adapter.model;

public class Hat {
	private String longName;
	private String shortName;
	private double basePrice;
	private double tax;
	public Hat(String longName, String shortName, double basePrice, double tax) {
		super();
		this.longName = longName;
		this.shortName = shortName;
		this.basePrice = basePrice;
		this.tax = tax;
	}
	public String getLongName() {
		return longName;
	}
	public void setLongName(String longName) {
		this.longName = longName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	
	
}
