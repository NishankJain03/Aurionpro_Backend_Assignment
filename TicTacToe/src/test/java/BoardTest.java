import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {

	Board board;
	Cell[] cell;
	@BeforeEach
	void init() {
		board = new Board();
		cell = new Cell[9];
	}
	@Test
	void testBoard() {
		for(Cell cell: board.getCells()) {
			assertEquals(MarkType.EMPTY, cell.getMarkType());
		}
	}

	@Test
	void testIsBoardFull() {
		for(int i=0;i<9;i++) {
			board.setCellMark(i, MarkType.X);
			
		}
		assertTrue(board.isBoardFull());
	}

	@Test
	void testSetCellMark() {
		board.setCellMark(0, MarkType.X);
		assertEquals(MarkType.X, board.getCells()[0].getMarkType());
	}

	@Test
	void testGetCells() {
		for(Cell cell : board.getCells()) {
			assertEquals(MarkType.EMPTY, cell.getMarkType());
		}
	}

	@Test
	void testSetCells() {
		for(int i=0;i<9;i++) {
			cell[i] = new Cell(MarkType.X);
		}
		board.setCells(cell);
		for(Cell cell : board.getCells()) {
			assertEquals(MarkType.X, cell.getMarkType());
		}
	}

}
