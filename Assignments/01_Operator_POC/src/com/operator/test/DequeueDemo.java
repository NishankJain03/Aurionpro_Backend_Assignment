package com.operator.test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DequeueDemo {

	public static void main(String[] args) {
		Deque<Integer> deque = new ArrayDeque<>();
		
		//adding the elements
		deque.addFirst(1);
		deque.addFirst(3);
		deque.addFirst(4);
		deque.addFirst(6);
	    deque.addLast(2);
	    
	    //iterating the elements
	    for (Iterator itr = deque.iterator();
	    	itr.hasNext();) {
	        System.out.print(itr.next() + " ");
	    }
	    System.out.println();

	    for (Iterator itr = deque.descendingIterator();
	    	itr.hasNext();) {
	    	System.out.print(itr.next() + " ");
	    }
	    
	    // where pop() is used to remove and return the head of the deque. 
	    // poll() is used because this offers the same functionality as pop() and doesn’t return an exception when the deque is empty.
	    System.out.println(deque.pop());
	    System.out.println(deque.poll());

        
        

	}

}

//is a queue that allows elements to be added and removed from both ends
//special kind of array that grows and allows users to add or remove an element from both sides of the queue.
//Array deques have no capacity restrictions and they grow as necessary to support usage
//ArrayDeque class is likely to be faster than Stack when used as a stack
//ArrayDeque class is likely to be faster than LinkedList when used as a queue.