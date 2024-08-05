package com.assignment.test;
import java.util.ArrayList;

import com.assignment.model.Number;

public class NumberTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList <Integer> number = new ArrayList<>(10);
		ArrayList <Integer> numberNew = new ArrayList<>(20);
		
		
		Number number1 = new Number(10);
		Number number2 = new Number(20);
		
		System.out.println("Before Swapping");
		System.out.println("Number1 " + number1.getValue()+ " Number2 " + number2.getValue());
		
		
		swap(number1, number2);
		
		System.out.println("After Swapping");
		System.out.println("Number1 " + number1.getValue()+ " Number2 " + number2.getValue());
	}
	private static void swap(Number number1, Number number2) {
		int temp = number1.getValue();
		number1.setValue(number2.getValue());
		number2.setValue(temp);
	}

}



// we cannot use wrapper class because it automatically converts the object into the integer and integer to object