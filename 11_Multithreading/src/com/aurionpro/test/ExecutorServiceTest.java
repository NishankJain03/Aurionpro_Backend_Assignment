package com.aurionpro.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.aurionpro.threads.NewTask;

public class ExecutorServiceTest {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		//for callable we need to user service.submit
		
		Future<Double> future = service.submit(new NewTask());
		
		
		//if we have a list of tasks
		List<NewTask> tasks = new ArrayList<NewTask>();
		tasks.add(new NewTask());
		tasks.add(new NewTask());
		tasks.add(new NewTask());
		tasks.add(new NewTask());
		tasks.add(new NewTask());
		
		//to invoke any random task
		try {
//			double number = service.invokeAny(tasks);
//			System.out.println(number);
			
			//to invoke all the task
			List<Future<Double>> futures = service.invokeAll(tasks);
			for(Future<Double> newFuture : futures)
				System.out.println(newFuture.get());
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(future.getClass());
		System.out.println(future.isDone());
		System.out.println(future.isCancelled());
		System.out.println();
		

	}

}
