package com.operator.test;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
		//adding the elements
		  pQueue.add(10);
		  pQueue.add(20);
		  pQueue.add(15);
		  pQueue.add(18);
		  
		 //iterating the element
		  Iterator iterator = pQueue.iterator();
		  
		  while (iterator.hasNext()) {
			  System.out.print(iterator.next() + " ");
	      }
		  
		  //size of the priority queue
		  System.out.println("Size of queue: " + pQueue.size());
		  
		  // checking whether it is empty
		  System.out.println("Is the queue empty? " + pQueue.isEmpty());
		  
		  //peek -->accessing 
		  System.out.println(pQueue.peek());
		  
		  //removing the element
	        System.out.println(pQueue.poll());
	        
	       //accessing the element
	         System.out.println(pQueue.peek());
		  
		  

	}

}

//is used when the objects are supposed to be processed based on the priority.
//The elements of the priority queue are ordered according to the natural ordering, or by a Comparator
//We can’t create a PriorityQueue of Objects that are non-comparable
//PriorityQueue is not thread-safe, java provides alternative PriorityBlockingQueue
//least value is the head


//add --> This method inserts the specified element into this priority queue.
//peek -->  This method retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
//poll --> This method retrieves and removes the head of this queue, or returns null if this queue is empty.
