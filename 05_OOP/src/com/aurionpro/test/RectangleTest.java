package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Rectangle;

public class RectangleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		Rectangle rectangle = new Rectangle();
		System.out.println("Height " + rectangle.getHeight());
		System.out.println("Width " + rectangle.getWidth());
		
		rectangle.area();
		
		System.out.println("Enter the height");
		int height = scanner.nextInt();
		
		System.out.println("Enter the width");
		int width = scanner.nextInt();
	
		Rectangle rectangle1 = new Rectangle(width, height);	
		
		rectangle1.area(height, width);
		
	}

}
