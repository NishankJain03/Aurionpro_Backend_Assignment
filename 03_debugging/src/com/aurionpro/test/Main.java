package com.aurionpro.test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		//type conversion and type casting
		//type conversion -> implicit
		
		double a = 10;
		
		//type casting
		int b = (int)10.5;
		int c = (int) 46.0f;
		
		//type promotion
		byte d = 10;
		byte e = (byte)(d + 10);
		System.out.println(e);
		
		//wrapper classes are used to represent normal dataypes as object
		// autoboxing -> represnt normal dataype as an object and vice versa is unboxing
		//Autoboxing
		Integer obj1 = b;
		obj1.intValue();
		System.out.println(obj1);
		System.out.println(obj1.getClass().getName());
		
		//unboxing
		int f = obj1;
		System.out.println(((Object)f).getClass().getName());
		
	
	}

}
