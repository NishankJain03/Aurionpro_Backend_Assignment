package com.aurionpro.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionClass {

	public static void main(String[] args) throws ClassNotFoundException {
		Class stringClass = Class.forName("java.lang.String");
		
		System.out.println(stringClass.getName());
		System.out.println(stringClass.getSimpleName());
		
		
		System.out.println("Methods");
		Method stringMethod[] = stringClass.getMethods();
		for(Method method : stringMethod) {
			System.out.println(method.getName());
		}
		
		System.out.println("Constructor");
		Constructor stringConstructor[] = stringClass.getConstructors();
		
		for(Constructor constructor : stringConstructor) {
			Parameter parameter[] = constructor.getParameters();
			for(Parameter parameters : parameter) {
				System.out.println(parameters.getName());
			}
			
 		}
		
		

	}

}
