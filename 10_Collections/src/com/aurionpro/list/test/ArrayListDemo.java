package com.aurionpro.list.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList<String> list = new ArrayList();
		List<String> list = new ArrayList<String>();
		
		System.out.println(list);
		System.out.println(list.size());
		
		list.add("chirag");
		list.add("jain");
		
//		System.out.println(list);
		
		list.add(1, "suyash");
//		System.out.println(list);
		
		list.add(3, "jain");
//		System.out.println(list);
		
		list.remove("suyash");
//		System.out.println(list);
		
		list.remove("jain");
//		System.out.println(list);
		
		System.out.println(list.contains("chirag"));
		
		
		System.out.println(list.get(1));
		System.out.println(list.set(0, "nishank"));
		System.out.println(list);
		
		
		//if we have array and want to convert them into list
		List<Integer> list1 = Arrays.asList(10,20,303,30,40);
		System.out.println(list1);
		
		list.add("adb");
		list.add("bcd");
		
		//accessing the elements in the four different ways
		//1.
		System.out.println("Using the normal for loop");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println("Using the advanced for loop");
		for(String name: list)
			System.out.println(name);
		
		System.out.println("Using the iterator");
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext())
			System.out.println(iterator.next());
		
		//but the iterator has the disadvantage that it can only traversed in forward direction
		//for backward direction
		
		System.out.println("Using List Operaator");
		ListIterator<String> iterator1 = list.listIterator();
		while(iterator1.hasNext())
			System.out.println(iterator1.next());
		
		System.out.println("Using List Operator but in reverse direction");
		while(iterator1.hasPrevious())
			System.out.println(iterator1.previous());
	}

}
//inorder to specify that arraylist should work on particular data we use generics
