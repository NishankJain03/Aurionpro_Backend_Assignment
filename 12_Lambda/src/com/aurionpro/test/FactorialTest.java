package com.aurionpro.test;

import com.aurionpro.model.Factorial;

public class FactorialTest {

	public static void main(String[] args) {
		
		Factorial factorial = (int number) -> {
				int fact =1;
				for(int i=number;i>0;i--) {
					fact = fact * i;
				}
				return  fact;
		};
		System.out.println(factorial.factorial(5));

	}

}

//built in interface
//Consumer ==> accepts only one argument return nothing method is void accepts(T t) any object (if specific use generics)
//Supplier --> return some value but does not accept --> method is get	T get()


