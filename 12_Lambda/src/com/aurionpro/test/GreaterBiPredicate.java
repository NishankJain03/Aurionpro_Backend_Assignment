package com.aurionpro.test;

import java.util.function.BiPredicate;

public class GreaterBiPredicate {

	public static void main(String[] args) {
		
		BiPredicate<Integer, Integer> greaterNumber = (Integer number1, Integer number2) -> (number1 > number2);
		System.out.println(greaterNumber.test(5, 9));

	}

}
