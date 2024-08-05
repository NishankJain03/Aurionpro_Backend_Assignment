package com.aurionpro.threads;

public class MyThread extends Thread{
	public MyThread(String name) {
		super(name);
		//we have written this because when the thread is created it goes into born state then when 
		//constructor is called the start is called and it goes into runnable
		start();
	}
	
	public void run() {
		for(int i =5; i>0;i--) {
			System.out.println(Thread.currentThread().getName()+ " " + i);
//			System.out.println(Thread.currentThread().getPriority());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
