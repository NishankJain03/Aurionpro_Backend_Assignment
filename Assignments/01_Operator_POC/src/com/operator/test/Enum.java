package com.operator.test;


//can be declared inside or outside the class
enum Color{
	RED,
	GREEN,
	YELLOW,
	WHITE;
	
//	public static void main(String[] args) {
//		
//		Color color1 = Color.GREEN;
//		System.out.println(color1);
//	}
}
public class Enum {

	public static void main(String[] args) {
		
		Color color = Color.YELLOW;	
	       
        // Switch case with Enum
        switch(color){
        case RED:
          System.out.println("Red color observed");
          break;
        case GREEN:
          System.out.println("Green color observed");
          break;
        case WHITE:
          System.out.println("Blue color observed");
        default:
          System.out.println("Other color observed");
      }
	}

}


//represents a group of named constants  --> define our own datatypes , represents object of type enum
// can be passed as an arguement to the switch statement
//every enum is always implicitly public static final
//used when we know all possible values at compile time (menu, modes)
// we can write constructor, add variable, methods 
// enumeration can neither be inherit nor can get extended
//we can declare the main function inside the enum 

