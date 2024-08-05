package com.aurionpro.model;

public class Car {
	//required parameters
	private String engine;
	private int wheels;
	
	//optional parameters
	private boolean airConditioning;
	private boolean sunRoof;
	private boolean GPS;
	
	private Car(CarBuilder builder) {
		this.engine = builder.engine;
		this.wheels = builder.wheels;
		this.airConditioning  = builder.airConditioning;
		this.sunRoof = builder.sunRoof;
		this.GPS = builder.GPS;
	}

	public String getEngine() {
		return engine;
	}

	public int getWheels() {
		return wheels;
	}

	public boolean isAirConditioning() {
		return airConditioning;
	}

	public boolean isSunRoof() {
		return sunRoof;
	}

	public boolean isGPS() {
		return GPS;
	}

	@Override
	public String toString() {
		return "Car [engine=" + engine + ", wheels=" + wheels + ", airConditioning=" + airConditioning + ", sunRoof="
				+ sunRoof + ", GPS=" + GPS + "]";
	}
	
	//Builder class
	public static class CarBuilder{
		private String engine;
		private int wheels;
		
		//optional parameters
		private boolean airConditioning;
		private boolean sunRoof;
		private boolean GPS;
		
		public CarBuilder(String engine, int wheels) {
			this.engine = engine;
			this.wheels = wheels;
		}


		public CarBuilder setAirConditioning(boolean airConditioning) {
			this.airConditioning = airConditioning;
			return this;
		}

		public CarBuilder setSunRoof(boolean sunRoof) {
			this.sunRoof = sunRoof;
			return this;
		}

		public CarBuilder setGPS(boolean gPS) {
			GPS = gPS;
			return this;
		}
		
		//calls the private Car constructor to set the fields of the Car.
		public Car build() {
			return new Car(this);
		}
		
		
	}
	
	
}
