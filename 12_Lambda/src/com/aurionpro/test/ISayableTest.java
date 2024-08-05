package com.aurionpro.test;

import com.aurionpro.model.ISayable;

public class ISayableTest {

	public static void main(String[] args) {
		//instead of creating a another class to define the method we can write here
		ISayable sayable = () -> System.out.println("I am inside sayable");
		
		//this method definition we can pass as an argument to another method
		
		sayHello(sayable);
		
		sayable.say();
	}
	
	private static void sayHello(ISayable sayable) {
		sayable.say();
	}

}
