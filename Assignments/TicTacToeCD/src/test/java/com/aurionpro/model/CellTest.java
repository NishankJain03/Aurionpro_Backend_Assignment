package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CellTest {

	@Test
	void testCell() {
		Cell cell = new Cell(MarkType.X);
		assertEquals(MarkType.X, cell.getMarkType());
		assertFalse(cell.isEmpty());
	}

	@Test
	void testIsEmpty() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMarkType() {
		fail("Not yet implemented");
	}

	@Test
	void testSetMarkType() {
		fail("Not yet implemented");
	}

}
