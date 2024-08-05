package com.aurionpro.creational.factory.test;

import com.aurionpro.creational.factory.model.Car;
import com.aurionpro.creational.factory.model.CarFactory;
import com.aurionpro.creational.factory.model.ICar;
import com.aurionpro.creational.factory.model.Mahindra;
import com.aurionpro.creational.factory.model.Maruti;
import com.aurionpro.creational.factory.model.Tata;

public class CarTest {

	public static void main(String[] args) {
		ICar car;
		car = CarFactory.makeCar(Car.MARUTI);
		car.start();
		car.stop();

	}

}
