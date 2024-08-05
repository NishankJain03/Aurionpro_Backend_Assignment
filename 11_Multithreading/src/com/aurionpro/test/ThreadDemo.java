package com.aurionpro.test;

public class ThreadDemo {

	public static void main(String[] args) {
		Thread myThread =  Thread.currentThread();
		System.out.println(myThread);
		
		//set the name
		myThread.setName("myNewThread");
		
		for(int i=0;i<5;i++) {
			System.out.println(Thread.currentThread().getName()+ ":" + i);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
//main is first thread --> from this all thread are created and it is often the last thread to execute