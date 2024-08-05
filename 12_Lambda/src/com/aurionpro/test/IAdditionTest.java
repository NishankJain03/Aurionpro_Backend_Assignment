package com.aurionpro.test;

import com.aurionpro.model.IAddition;

public class IAdditionTest {

	public static void main(String[] args) {
		
		//if you write curly bracket you need to write return statement
		IAddition adder = (number1, number2) -> number1 + number2; 	
		System.out.println(adder.addition(10, 20));

	}

}
