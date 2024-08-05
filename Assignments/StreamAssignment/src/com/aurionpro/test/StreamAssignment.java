package com.aurionpro.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAssignment {

	public static void main(String[] args) {
		
		List<String> strings = Arrays.asList("Jayesh", "Nimesh", "Mark", "Mahesh" , "Ramesh");
		
		//sort in ascending order first 3 student
		System.out.println("Ascending order");
		List<String> ascString =  strings.stream().limit(3).sorted().collect(Collectors.toList());
		ascString.forEach((string) -> System.out.println(string));
		
		//sort first 3 in ascending if contains a
		System.out.println("sort first 3 in ascending if contains a");
		List<String> withA = strings.stream().filter(string -> string.contains("a")).collect(Collectors.toList());
		List<String> sortedA = withA.stream().limit(3).sorted().collect(Collectors.toList());
		sortedA.forEach((string) -> System.out.println(string));
		
		System.out.println("Sort in descending order");
		List<String> descString = strings.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		descString.forEach((string) -> System.out.println(string));
		
		System.out.println("First three character");
		List<String> threeChar = strings.stream().map(string1 -> string1.length()>=3 ?  string1.substring(0,3): string1 ).collect(Collectors.toList());
		threeChar.forEach((string) -> System.out.println(string));
		
		System.out.println("Name of student that contain less than or equal to 4 character");
		List<String> fourChar = strings.stream().filter(string -> string.length() <= 4).collect(Collectors.toList());
		fourChar.forEach((string) -> System.out.println(string));

	}

}
