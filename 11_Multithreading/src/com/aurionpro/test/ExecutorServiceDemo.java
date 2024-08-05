package com.aurionpro.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.aurionpro.threads.Task;

public class ExecutorServiceDemo {

	public static void main(String[] args) {
		//to get the number of processor available 
		int coreCount = Runtime.getRuntime().availableProcessors();
		System.out.println(coreCount);
		
		
//		ExecutorService service = Executors.newFixedThreadPool(coreCount);
		//here you can also mention the number
		
//		ExecutorService service = Executors.newCachedThreadPool();
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		for(int i=0;i<1000;i++) {
			service.execute(new Task());
		}

	}

}
