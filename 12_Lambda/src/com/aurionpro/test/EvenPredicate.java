package com.aurionpro.test;

import java.util.function.Predicate;

public class EvenPredicate {

	public static void main(String[] args) {
		Predicate<Integer> evenPredicate = (Integer number) -> (number % 2 == 0) ;
		System.out.println(evenPredicate.test(4));

	}

}
