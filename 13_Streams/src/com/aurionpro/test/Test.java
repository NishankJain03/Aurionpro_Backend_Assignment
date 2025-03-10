package com.aurionpro.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(20,23,45,67,23,34,45,5,565,76);
		
//		Stream<Integer> numberStream = numbers.stream();
//		
//		numberStream.forEach((number) -> System.out.println(number));
		
		//the above two line can be written in this way
//		System.out.println("All the number");
//		numbers.stream().forEach((number ) -> System.out.println(number));
		
		
		//filtering out the odd
//		System.out.println("Odd values greater than 25 ");
		List<Integer> filteredNumber = numbers.stream()
				.filter((number) -> (number % 2 != 0))
				.filter((number) -> (number > 25))
//				.forEach((number) -> System.out.println(number));
				.collect((Collectors.toList()));
		
//		filteredNumber.stream().forEach((number) -> System.out.println(number));
//		for(Integer number: filteredNumber )
//			System.out.println(number);
		
//		List<Integer> squareNumber = numbers.stream()
//				.map((number) -> number * number)
//				.collect(Collectors.toList());
		
//		System.out.println("Square of the number is ");
//		for(Integer number: squareNumber)
//			System.out.println(number);
		
		
		//if you want to perform operation that return only single value so we use reduce
		int sum = numbers.stream().reduce(0,(number1,number2) -> number1+number2);
		System.out.println("Sum: " + sum);
		
		List<Integer> sortedNumber = numbers.stream().sorted().collect(Collectors.toList());
		sortedNumber.stream().forEach((number) -> System.out.println(number));
		
		//to print it in reverse order we use .sorted(Comparator.reverseOrder());
		
		List<Integer> descSortedNumber = numbers.stream().sorted(Comparator.reverseOrder()).limit(2).collect(Collectors.toList());
		descSortedNumber.stream().forEach((number) -> System.out.println(number));
		
		//if we want a certain number of elements we can use limit 
		
		//if we need to find max element
		Optional<Integer> max = numbers.stream().max((number1,number2) -> number1 - number2);
		if(max.isPresent())
			System.out.println("Max is " + max.get());
		
		//min element
		Optional<Integer> min = numbers.stream().min((number1,number2) -> number1 - number2);
		if(min.isPresent())
			System.out.println("Min is " + min.get());

	}

}
