import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultAnalyzerTest {
	private Board board;
	private ResultAnalyzer analyzer;
	
	@BeforeEach
	public void init() {
		board = new Board();
		analyzer = new ResultAnalyzer(board);
	}
	
	@Test
	public void testHorizontalWinCheck() {
		board.setCellMark(0, MarkType.X);
		board.setCellMark(1, MarkType.X);
		board.setCellMark(2, MarkType.X);
		ResultType result = analyzer.analyseResult();
		assertEquals(ResultType.WIN, result);
	}
	
	@Test
	public void testVertitalWinCheck() {
		board.setCellMark(0, MarkType.X);
		board.setCellMark(3, MarkType.X);
		board.setCellMark(6, MarkType.X);
		ResultType result = analyzer.analyseResult();
		assertEquals(ResultType.WIN, result);
	}
	
	@Test
	public void testDiagonalWinCheckLeft() {
		board.setCellMark(0, MarkType.X);
		board.setCellMark(4, MarkType.X);
		board.setCellMark(8, MarkType.X);
		ResultType result = analyzer.analyseResult();
		assertEquals(ResultType.WIN, result);
	}
	
	@Test
	public void testDiagonalWinCheckRight() {
		board.setCellMark(2, MarkType.X);
		board.setCellMark(4, MarkType.X);
		board.setCellMark(6, MarkType.X);
		ResultType result = analyzer.analyseResult();
		assertEquals(ResultType.WIN, result);
	}
	
	@Test
	public void testDrawCondition() {
		board.setCellMark(0, MarkType.X);
		board.setCellMark(1, MarkType.O);
		board.setCellMark(2, MarkType.X);
		board.setCellMark(3, MarkType.X);
		board.setCellMark(4, MarkType.O);
		board.setCellMark(5, MarkType.X);
		board.setCellMark(6, MarkType.O);
		board.setCellMark(7, MarkType.X);
		board.setCellMark(8, MarkType.O);
		ResultType result = analyzer.analyseResult();
		assertEquals(ResultType.DRAW, result);
		
	}
	
	@Test
	public void testProgressCondition() {
		board.setCellMark(0, MarkType.X);
		board.setCellMark(1, MarkType.O);
		ResultType result = analyzer.analyseResult();
		assertEquals(ResultType.PROGRESS, result);
		
	}
	
	
}


