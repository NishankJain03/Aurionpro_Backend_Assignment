package com.aurionpro.test;

import com.aurionpro.model.Component;
import com.aurionpro.model.Composite;
import com.aurionpro.model.Leaf;

public class CompositeTest {

	public static void main(String[] args) {
		Component hdd = new Leaf("hdd", 4000);
		Component keyboard = new Leaf("keyboard",1000);
		Component mouse = new Leaf("mouse", 500);
		Component ram =  new Leaf("ram", 3000);
		Component processor = new Leaf("Processor", 10000);
		
		Composite computer = new Composite("computer");
		Composite motherboard = new Composite("motherboard");
		motherboard.add(ram);
		motherboard.add(processor);
		
		Composite cabinet = new Composite("cabinet");
		cabinet.add(hdd);
		cabinet.add(motherboard);
		
		Composite peripherals = new Composite("peripherals");
		peripherals.add(keyboard);
		peripherals.add(mouse);
		
		computer.add(cabinet);
		computer.add(peripherals);
		
		computer.showPrice();

	}

}
/*
this is the structural design pattern 
represent a part - whole hierarchy 
allow us to treat the individual objects and the composition of objects in the same way

					computer
		cabinet						peripherals
	hdd		motherboard			keyboard		mouse
			ram	processor



composite objects
leaf object
if we want to know the price to see the price of each object 
so method applied for the leaf object can also be applied for the composite objects





*/