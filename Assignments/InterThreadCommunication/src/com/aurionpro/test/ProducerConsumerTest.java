package com.aurionpro.test;
import com.aurionpro.model.Consumer;
import com.aurionpro.model.Producer;
import com.aurionpro.model.Queue;

public class ProducerConsumerTest {

	public static void main(String[] args) {
		Queue queue1 = new Queue();
        new Producer(queue1);
        new Consumer(queue1);
        

	}

}
//three methods
//wait -->  It tells the calling thread to give up the lock and go to sleep until some other thread enters the same monitor and calls notify().	
//notify --> It wakes up one single thread called wait() on the same object. It should be noted that calling notify() does not give up a lock on a resource.
//notifyAll() --> used to wake up all the thread that called wait()
//it works only within synchronized context

//Inter-thread communication in Java is a mechanism in which a thread is paused running in its critical section and another thread is allowed to enter (or lock) in the same critical section to be executed.
///What is Polling, and what are the problems with it? 

//The process of testing a condition repeatedly till it becomes true is known as polling.
// Polling is usually implemented with the help of loops to check whether a particular condition is true or not. 
//If it is true, a certain action is taken. This wastes many CPU cycles and makes the implementation inefficient. 


