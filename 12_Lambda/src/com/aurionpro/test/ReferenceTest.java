package com.aurionpro.test;

import com.aurionpro.model.ITest;
import com.aurionpro.model.Reference;

public class ReferenceTest {

	public static void main(String[] args) {
		
		ITest test = Reference:: new;
		method(test);
		
		ITest test1 = Reference::staticPrint;
		method (test1);
		
		Reference reference = new Reference();
		ITest test2 = reference::print;
		method(test2);

	}
	
	public static void method(ITest test) {
//		test.display(1);
		test.display();
	}

}
