package com.aurionpro.test;

import java.util.function.Consumer;

public class FactorialConsumer {

	public static void main(String[] args) {
		Consumer<Integer>consumer = (Integer number) -> {
			int fact = 1;
			for(int i=number ;i>0;i--)
				
			{
				fact *= i;
			}
			System.out.println(fact);
		};
		consumer.accept(5);

	}

}
