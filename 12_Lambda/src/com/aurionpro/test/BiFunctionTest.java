package com.aurionpro.test;

import java.util.function.BiFunction;

public class BiFunctionTest {

	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer > additionBiFunction = (Integer number1, Integer number2) -> (number1 + number2);
		System.out.println(additionBiFunction.apply(5, 6)); 

	}

}
