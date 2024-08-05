package com.aurionpro.test;

import com.aurionpro.threads.MyThread;

public class ThreadDemo1 {

	public static void main(String[] args) {
		
		
		//we need to create the object of the thread
		MyThread thread1 = new MyThread("Thread1");
		MyThread thread2 = new MyThread("Thread2");
		MyThread thread3 = new MyThread("Thread3");		
		//we could also have written the start method here but to call it automatically when object is created 
		//we have written in constructor
		System.out.println(thread1.isAlive());
		System.out.println(thread2.isAlive());
		System.out.println(thread3.isAlive());
		
		//setting the priority
		thread1.setPriority(Thread.MIN_PRIORITY);
		thread2.setPriority(Thread.MAX_PRIORITY);
		thread3.setPriority(Thread.NORM_PRIORITY);
		
		for(int i=5;i>0;i--) {
			System.out.println(Thread.currentThread().getName()+ " " + i);
//			Thread.currentThread().setPriority(2);
//			System.out.println(Thread.currentThread().isAlive());
//			System.out.println(Thread.currentThread().getPriority());
//			System.out.println(Thread.activeCount());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			thread1.join();
			thread2.join();
			thread3.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(thread1.isAlive());
		System.out.println(thread2.isAlive());
		System.out.println(thread3.isAlive());

	}

}
