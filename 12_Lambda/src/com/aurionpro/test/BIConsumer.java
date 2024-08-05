package com.aurionpro.test;

import java.util.function.BiConsumer;

public class BIConsumer {

	public static void main(String[] args) {
		BiConsumer<Integer, Integer> addition = (Integer number1, Integer number2)  -> System.out.println("addition is " + (number1+number2));
		addition.accept(5, 8);

	}

}
