package com.aurionpro.test;

import com.aurionpro.model.Base;
import com.aurionpro.model.Derived1;
import com.aurionpro.model.Derived2;

public class BaseTest {

	public static void main(String[] args) {
		Base base = new Base();
		
		base = new Derived1();
		base.display();
		
		base = new Derived2();
		base.display();
		
//		Derived2 derived1 = new Derived2();
//		derived1 = new Base();
		

	}

}


//super class reference can refer to subclass object but the child class cannot to other child class and super class
//at run time it is decided which method to call based on which class reference is referring to which class/subclass

// now super class can only refer to the content of the derived class which are inherited from the super class
// the og content of the derived class cannot be accessed


