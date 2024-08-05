package com.aurionpro.threads;

public class CallerThread implements Runnable{

	private String message;
	
	private CallMe target;
	private Thread thread;
	public CallerThread(String message, CallMe target) {
		super();
		this.message = message;
		this.target = target;
		this.thread = new Thread(this);
		this.thread.start();
	}
	
	public Thread getThread() {
		return thread;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (target) 
		{
		target.call(message);
		}
	}
	//or else you can do this 

}
