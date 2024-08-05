package com.aurionpro.test;

import com.aurionpro.threads.RunnableThread;

public class RunnableThreadTest {

	public static void main(String[] args) {
		RunnableThread thread = new RunnableThread();
		
		
		try {
			thread.getThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
