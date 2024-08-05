package com.operator.test;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		
		//adding the elements
		queue.add("apple");
		queue.add("banana");
		queue.add("cherry");
		
		//print the queue
		System.out.println("Queue" + queue);
		
		//remove the elements at the front of the queue
		String front = queue.remove();
		System.out.println("Removed element "  + front);
		System.out.println("Updated queue " + queue);
		
		//adding the element again
		queue.add("date");
		String peeked = queue.peek();
		System.out.println("Peeked element " + peeked);
		System.out.println("Queue after peek " + queue);
		
		
		

	}

}
//it follows the FIFO principle
//it is use to inserting the elements at the end of the list and deleting from the start of the list
//methods
//add --> add element if full throw exception
//offer --> add the element if full return null
//remove --> remove and return the element at front if empty throw exception
//poll  --> remove and return the element at front if empty return null
//element --> return element at front without removing it if empty throw exception
//peek --> return element at front without removing it if empty return null
//can be implemented by several classes linkedlist, arraydeque, priorityqueue