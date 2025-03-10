package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperationTest {
	Operation operations;
	
	@BeforeEach
	void init() {
		operations = new Operation();
	}
//	@BeforeAll
//	void init() {
//		operations = new Operation();
//	}
	//if want new object every time --> instead of writing many time we can create a method BeforeEach
	//for common object we can declare above or use BEFOREALL --> static reference
	
	//if we want to print status after execution we can use after each and after all
	@AfterEach
	void status() {
		System.out.println("All Test cases executed successfully");
	}
	
	@Test
	void testAddition() {
		assertEquals(10, operations.addition(5, 5),"This function must do addition");
	}

	@Test
	void testSubtraction() {
		assertEquals(0, operations.subtraction(5, 5));
	}

	@Test
	void testMulitplication() {
		assertEquals(25, operations.mulitplication(5, 5));
		assertEquals(4, operations.mulitplication(2, 2));
	}

	@Test
	void testDivision() {
		assertEquals(1, operations.division(5, 5));
		assertThrows(ArithmeticException.class, () -> operations.division(5, 0));
	}
	
	
	
	
}
