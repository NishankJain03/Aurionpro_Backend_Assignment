package com.aurionpro.test;

import java.util.function.Supplier;

public class RandomNumberSupplier {

	public static void main(String[] args) {
		Supplier <Integer> randomNumber = () -> (int) Math.random()  + 1;
		System.out.println(randomNumber.get());

	}

}
