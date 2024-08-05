package com.operator.test;

class Outer{
	private void outerMethod() {
		System.out.println("I am outer method");
	}
	class Inner{
		public void show() {
			System.out.println("I am inner class");
			outerMethod();
		}
	}
}

class Outer2{
	private static void outerMethod() {
		System.out.println("I am outer method");
	}
	
	static class Inner2 {
		public void show() {
			System.out.println("I am inner class");
			outerMethod();
		}
	}
	
}

//anonymous
class Demo{
	void show() {
		System.out.println("I am in the Demo class");
	}
}

class DerivedClass{
	public Demo d = new Demo() {
		void show() {
			super.show();
			System.out.println("I am the derived class");
		}
	};
}



public class InnerClass {

	public static void main(String[] args) {
		
//		Outer outerClass = new Outer();
//		Outer.Inner innerClass = outerClass.new Inner();
//		innerClass.show();
		
		Outer2.Inner2 innerClass = new Outer2.Inner2();
		innerClass.show();
		
		DerivedClass derivedClass = new DerivedClass();
		derivedClass.d.show();
		
	}

}

//to make code more readable and maintainable
//to access the inner class we need to create a object of outer class then create a obejct of inner class
//unlike outer class we can make inner class private or protected and static
//if we make inner class private outer class can't access the inner class
//if we make the inner class static we can access the inner class without making the object
//inner classes can access attributes(any) and methods(private) of the outer class


//four types of inner class 1) nested inner class 
//2) method local inner classes
// 3) static nested classes
//4) anonymous inner classes
