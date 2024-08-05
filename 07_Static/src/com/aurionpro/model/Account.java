package com.aurionpro.model;

public class Account {
	
	private static int count = 0;
	
//	{
//		System.out.println("Number of Object created " + ++count);
//	}
	public Account(){
		System.out.println(++count);
	}

}

