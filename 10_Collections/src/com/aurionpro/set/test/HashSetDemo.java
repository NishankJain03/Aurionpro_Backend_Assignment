package com.aurionpro.set.test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class HashSetDemo {

	public static void main(String[] args) {
		System.out.println("Using the hashset");
		HashSet<String> hashset = new HashSet<String>();
		
		hashset.add("Kaivalya");
		hashset.add("Chirag");
		hashset.add("Chirag");
		hashset.add("Shivam");
		
		System.out.println(hashset);
		
		System.out.println("Using the linked hashset");
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("Kaivalya");
		linkedHashSet.add("Chirag");
		linkedHashSet.add("Chirag");
		linkedHashSet.add("Shivam");
		
		System.out.println(linkedHashSet);
//		System.out.println(linkedHashSet.hashCode());
		
		System.out.println("Using the TreeSet ");
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.add("Kaivalya");
		treeSet.add("Chirag");
		treeSet.add("Chirag");
		treeSet.add("Shivam");
		
		System.out.println(treeSet);
		
	}

}
//hashSet stores the element in any random order
//linked hashSet maintains the order of the insertion
//TreeSet --> elements are store in sorted order --> default (Ascending)

