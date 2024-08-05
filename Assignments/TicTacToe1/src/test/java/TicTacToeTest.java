import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class TicTacToeTest {
	TicTacToe game;
	
	@BeforeEach
	 public void setUp() {
        game = new TicTacToe();
    }
    @Test
    public void testInitializeBoard() {
        char[][] board = game.getBoard();

        assertNotNull(board, "Board should not be null");
        assertEquals(3, board.length, "Board should have 3 rows");
        assertEquals(3, board[0].length, "Board should have 3 columns");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals('\0', board[i][j], "Board cells should be initialized to empty");
            }
        }
    }

    @Test
    public void testValidMove() {
        boolean result = game.markBoard(1, 1, 'X');
        char[][] board = game.getBoard();
        
        assertTrue(result, "Valid move should be successful");
        assertEquals('X', board[1][1], "Board should be marked with 'X' at position (1,1)");
        assertEquals('O', game.getCurrentPlayer(), "Turn should be switched to 'O'");
    }

    @Test
    public void testInvalidMove() {
        boolean result = game.markBoard(3, 3, 'X'); // Out of bounds
        game.markBoard(1, 1, 'O'); // Valid move
        
        char[][] board = game.getBoard();
        assertFalse(result, "Move outside of bounds should not be allowed");
        assertEquals('\0', board[3][3], "Move outside of bounds should not alter the board");
        assertEquals('O', board[1][1], "Valid move should correctly mark the board");
    }

    @Test
    public void testHorizontalWin() {
        game.markBoard(0, 0, 'X');
        game.markBoard(0, 1, 'X');
        game.markBoard(0, 2, 'X');
        
        assertTrue(game.checkWin(), "Player should win with a horizontal line of 'X's");
    }

    @Test
    public void testVerticalWin() {
        game.markBoard(0, 1, 'O');
        game.markBoard(1, 1, 'O');
        game.markBoard(2, 1, 'O');
        
        assertTrue(game.checkWin(), "Player should win with a vertical line of 'O's");
    }

    @Test
    public void testDiagonalWin() {
        TicTacToe game = new TicTacToe();
        game.markBoard(0, 0, 'X');
        game.markBoard(1, 1, 'X');
        game.markBoard(2, 2, 'X');
        
        assertTrue(game.checkWin(), "Player should win with a diagonal line of 'X's");
    }

    @Test
    public void testTie() {
        game.markBoard(0, 0, 'X');
        game.markBoard(0, 1, 'O');
        game.markBoard(0, 2, 'X');
        game.markBoard(1, 0, 'X');
        game.markBoard(1, 1, 'X');
        game.markBoard(1, 2, 'O');
        game.markBoard(2, 0, 'O');
        game.markBoard(2, 1, 'X');
        game.markBoard(2, 2, 'O');
        
        assertFalse(game.checkWin(), "There should be no winner");
        assertTrue(game.isDraw(), "The game should be a draw");
    }

    @Test
    public void testOverwrite() {
        game.markBoard(1, 1, 'X');
        boolean result = game.markBoard(1, 1, 'O'); // Overwriting
        
        char[][] board = game.getBoard();
        assertFalse(result, "Overwriting should not be allowed");
        assertEquals('X', board[1][1], "Board should remain 'X' after an invalid overwrite attempt");
    }

    @Test
    public void testPlayerTurn() {
        assertEquals('X', game.getCurrentPlayer(), "Player X should start the game");
        
        game.markBoard(0, 0, 'X');
        assertEquals('O', game.getCurrentPlayer(), "Turn should switch to player O after X's move");
        
        game.markBoard(1, 1, 'O');
        assertEquals('X', game.getCurrentPlayer(), "Turn should switch back to player X after O's move");
    }
}
