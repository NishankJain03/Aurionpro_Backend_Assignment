package com.aurionpro.model;

public class StaticTest {
	private static int a = 1;
	private static int b = 1;
	private static int c = 1;
	
	public void increment() {
		a++;
		b++;
		c++;
	}
	
	static public void display() {
		System.out.println("a value is " + a);
		System.out.println("b value is " + b);
		System.out.println("c value is " + c);
	}
	
}


//static method can access only static data and not the non-static data
// non static method can have accesss to both

//we cannot a make a class as static
//we can make class static if it is inner class(ie class within class)
//static object executes when the class is loaded not when object is loaded
//static method recides in the class not in the methods

//when we create a object of the particular class then a simple block statement is executed if the object of that
//particular class is not created the simple empty block statement will not executed

