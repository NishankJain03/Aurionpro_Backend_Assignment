package com.aurionpro.model;

public class Car extends FourWheeler{
	private int price;
	
	public Car(String companyName, double mileage, int price ){
		super(companyName, mileage);
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [Price=" + price + ", Mileage=" + getMileage() + ", CompanyName=" + getCompanyName() + "]";
	}

	
}
