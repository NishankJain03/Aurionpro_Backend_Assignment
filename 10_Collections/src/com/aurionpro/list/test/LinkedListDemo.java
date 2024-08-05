package com.aurionpro.list.test;

import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> list = new LinkedList<String>();
		//here there are different methods to add the element at first and last position
		list.add("nishank");
		list.add("jain");
		list.addFirst("first");
		list.addLast("last");
		
		for(String name: list)
			System.out.println(name);
		
		System.out.println("Last Element " + list.getLast());
		System.out.println("First Element " + list.getFirst());
	}

}
