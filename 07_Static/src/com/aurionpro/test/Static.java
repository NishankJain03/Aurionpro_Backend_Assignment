package com.aurionpro.test;

import com.aurionpro.model.StaticTest;

public class Static {

	public static void main(String[] args) {
		
		System.out.println("Object 1");
		StaticTest statictest1 = new StaticTest();
		StaticTest.display();
		statictest1.increment();
		StaticTest.display();
		
		System.out.println("Object 2");
		StaticTest staticTest2 = new StaticTest();
		StaticTest.display();
		staticTest2.increment();
		StaticTest.display();
		
		System.out.println("Object 3");
		StaticTest staticTest3 = new StaticTest();
		StaticTest.display();
		staticTest3.increment();
		StaticTest.display();

	}

}
