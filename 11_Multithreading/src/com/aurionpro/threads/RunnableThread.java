package com.aurionpro.threads;

public class RunnableThread implements Runnable{
	
	//here the start method not exist because it was of theread class
//	so to use it 
	private Thread thread;
	

	public RunnableThread() {
		thread = new Thread(this);
		thread.start();
	}


	public Thread getThread() {
		return thread;
	}


	public void setThread(Thread thread) {
		this.thread = thread;
	}


	@Override
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
