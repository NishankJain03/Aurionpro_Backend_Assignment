package com.aurionpro.model;

public class Producer implements Runnable{
	   Queue queue;

	    public Producer(Queue queue) {
	        this.queue = queue;
	        new Thread(this, "Producer").start();
	    }

	    public void run() {
	        for(int i=0;i<10;i++) {
	        	queue.put(i);
	        }
	    }
}
