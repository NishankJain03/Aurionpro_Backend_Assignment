package com.aurionpro.test;

import com.aurionpro.model.Box;
import java.util.Scanner;

public class BoxTest {
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//creating the object
		Box box = new Box();
		System.out.println("Height "+ box.getHeight());
		System.out.println("Depth "+ box.getDepth());
		System.out.println("Width "+ box.getWidth());
		
		System.out.println("Enter the height");
		int height = scanner.nextInt();
		System.out.println("Enter the depth");
		int depth = scanner.nextInt();
		System.out.println("Enter the width");
		int width = scanner.nextInt();
		
		Box box2 = new Box(width, depth, height);
		
		System.out.println("Height "+ box2.getHeight());
		System.out.println("Depth "+ box2.getDepth());
		System.out.println("Width "+ box2.getWidth());

	}

}


//constructor are the member methods that dont have any return type
//they are called automatically at the time of object creation
//they are used to initialize the objects
//there are two type of constructor 1) default 2) parameterised

//when we do not write constructor java provides its constructor of type default
//constructor is created for every class
// we can write as many constructor as we want for a class --> this is called constructor overloading

