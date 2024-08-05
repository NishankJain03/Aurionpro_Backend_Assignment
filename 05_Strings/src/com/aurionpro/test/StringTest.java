package com.aurionpro.test;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name1 = "Nishank";
		String name2 = "Nishank";
		
		String name3 = new String("Nishank");
		String name4 = new String("Nishank");
		
		name3 += "Jain";
		
		//to check if both the object are referencing to the same object
//		System.out.println(name1.hashCode() + " " + name2.hashCode());
//		System.out.println(name3.hashCode());
		
		System.out.println(name1 == name2);
		
		System.out.println(name3 == name4);
		
		StringBuffer name5 = new StringBuffer("Nishank");
		System.out.println(name5.hashCode());
		name5 = name5.append("Jain");
		System.out.println(name5.hashCode());
		
		
		//here the hashcode are same since string buffer are mutable
		
		
		StringBuilder name6 = new StringBuilder("Nishank");
		System.out.println(name6.hashCode());
		name6 = name6.append("Jain");
		System.out.println(name6.hashCode());
		
		//here the hashcode are same therefore string builder are mutable
		
	}

}
//since the strings are immutable any changes in the existing string creates a new string(copy) and the variable points to the new String
//identifiers are stored in the stack and objects are stored in the heap 
//if we use string name = "ef" it will stored in the heap (string pool)
//it stores in the heap memory

//string can be created using three class string, string Buffer and string builder

//in stringbuffer all the public methods are synchronised



//Use String for immutable strings and where performance isn't a concern for string modifications.
//Use StringBuilder for mutable strings in single-threaded scenarios where you need efficient string manipulation.
//Use StringBuffer for mutable strings in multi-threaded scenarios where thread safety is required, even though it's slightly less efficient than StringBuilder in single-threaded contexts.



//jar file is like zip file it contains all the projects, assests etc with manifest
//jar file is java archive file and manifest is the metadata of the jar  file 
//if we are using different version then we need to seal the jar file to prevent it from conflict of different version
