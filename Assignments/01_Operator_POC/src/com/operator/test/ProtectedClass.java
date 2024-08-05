package com.operator.test;

import com.operator.model.ProtectedClassEg;

public class ProtectedClass extends ProtectedClassEg{

	public static void main(String[] args) {
		ProtectedClass protectedClass = new ProtectedClass();
		protectedClass.display();

	}

}


//the methods or data members declared as protected are accessible within the same package or subclasses in different packages