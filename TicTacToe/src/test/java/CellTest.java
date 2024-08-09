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
		Cell cell = new Cell(MarkType.EMPTY);
		assertEquals(MarkType.EMPTY, cell.getMarkType());
		assertTrue(cell.isEmpty());
	}

	@Test
	void testGetMarkType() {
		Cell cell = new Cell(MarkType.EMPTY);
		assertEquals(MarkType.EMPTY, cell.getMarkType());
	}

	@Test
	void testSetMarkType() {
		Cell cell = new Cell(MarkType.EMPTY);
		cell.setMarkType(MarkType.X);
		assertEquals(MarkType.X, cell.getMarkType());
		assertFalse(cell.isEmpty());
	}

}
