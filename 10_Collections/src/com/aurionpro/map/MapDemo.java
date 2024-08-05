package com.aurionpro.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {

	public static void main(String[] args) {
//		HashMap<Integer, String> map = new HashMap<Integer,String>();
//		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer,String>();
		TreeMap<Integer, String> map = new TreeMap<Integer,String>();
		
//		map.put(7, "nishank");
//		map.put(2, "jain");
//		map.put(5, "shirish");
//		map.put(4, "vi");
		
		map.put(5, "chirag");
		map.put(4, "shirish");
		map.put(7, "vinayak");
		
		System.out.println(map);
		
		//here we need to convert map into set --> map.entrySet 
		Set<Entry<Integer,String>> entries = map.entrySet();
		
		for(Entry<Integer,String> entry: entries) {
			System.out.println(entry.getKey() + "-" + entry.getValue() );
//			entry.setValue("nishank");
//			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
		

	}

}
//map is the collection of entries where each entry contain key value pair where key and value are objects
//entries will be unique....key should be unique
//hashMap does not maintain order may have single null key and multiple null values
//treeMap give sorted value of keys no null key but have multiple 
//linkedHashmap --> maintains the insertion order
//HashMap does not preserve the iteration order while the TreeMap preserve the order by using the compareTo() method or a comparator set in the TreeMap's constructor.
//each individual entry is represented by Map.Entry