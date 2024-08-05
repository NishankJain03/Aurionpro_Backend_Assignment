package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AreaCalculatorTest {
	
	AreaCalculator areaCalculator;
	
	@BeforeEach
	void init() {
		areaCalculator = new AreaCalculator();
	}
	@Test
	void testCalculateAreaOfCircle() {
		assertEquals(78.5, areaCalculator.calculateAreaOfCircle(5));
	}
	@Test
	void testCalculateAreaOfRectangle() {
		assertEquals(25, areaCalculator.calculateAreaOfRectangle(5,5));
	}
	@Test
	void testCalculateAreaOfTriangle() {
		assertEquals(12.5, areaCalculator.CalculateAreaOfTriangle(5, 5));
	}
	
	
}
