package com.aurionpro.threads;

import java.util.concurrent.Callable;


//here if you want to allow method to return certain value you can use generics <mention the type>
public class NewTask implements Callable<Double>{

	@Override
	public Double call() throws Exception {
		return Math.random();
		
	}

}
