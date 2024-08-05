package com.aurionpro.test;

import java.util.function.Function;

public class FunctionTest {

	public static void main(String[] args) {
		//here we need to pass two arguments 1st will data type 2nd will be return type 
		Function<Integer, Integer> sqrFunction = (Integer number) -> (number * number);
		System.out.println(sqrFunction.apply(7));

	}

}
