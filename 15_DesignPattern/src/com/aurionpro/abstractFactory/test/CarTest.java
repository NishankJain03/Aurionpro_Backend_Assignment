package com.aurionpro.abstractFactory.test;

import com.aurionpo.abstractFactory.model.ICar;
import com.aurionpo.abstractFactory.model.ICarFactory;
import com.aurionpo.abstractFactory.model.MarutiFactory;

public class CarTest {
	public static void main(String[] args) {
		ICarFactory marutiFactory = new MarutiFactory();
		ICar maruti = marutiFactory.makeCar();
		maruti.start();
		maruti.stop();
	}
}
