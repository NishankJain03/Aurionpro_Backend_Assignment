package com.aurionpro.threads;

public class CallMe {
	public  void call(String message) {
		System.out.print("[" + message);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("]" );
	}
}


//in order to do the synchronization we can define the call method as synchronised because 
// until thread1 complete the function then only thread2 will execute