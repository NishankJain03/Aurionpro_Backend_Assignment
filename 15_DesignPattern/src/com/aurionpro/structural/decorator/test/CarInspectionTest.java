package com.aurionpro.structural.decorator.test;

import com.aurionpro.structural.decorator.model.CarInspection;
import com.aurionpro.structural.decorator.model.ICarService;
import com.aurionpro.structural.decorator.model.OilChange;
import com.aurionpro.structural.decorator.model.WheelAlign;

public class CarInspectionTest {

	public static void main(String[] args) {
		ICarService carService = new CarInspection();
		ICarService oilChange = new OilChange(carService);
		ICarService wheelAlign = new WheelAlign(oilChange);
		
		System.out.println(oilChange.getCost());
	}

}
