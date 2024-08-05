package com.aurionpro.test;

import com.aurionpro.model.Car;

public class CarTest {

	public static void main(String[] args) {
		Car car = new Car.CarBuilder("V8", 4)
						 .setAirConditioning(true)
						 .setSunRoof(true)
						 .setGPS(true)
						 .build();
		
		System.out.println(car);
						
						

	}

}
//	it helps us to construct complex objects step by step
//solves the issue with a large number of optional parameter
//--too many arguments pass 
//-- some of the parameter might be optional
//is designed to create objects using a nested public static class that has the same fields as the outer class
//
//
//
//steps:
//1. create a static nested class as a builder and then copy all the fields from the outer class to the builder class
//2. the builder class should have public constructor with all the required fields as parameters
//3. the builder class should have methods to set the optional parameters and it should return the same builder object after
//setting the optional field
//4. the final step is to provide the build() method in the builder class that will return object needed by the client program 






