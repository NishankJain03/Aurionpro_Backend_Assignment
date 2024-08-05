import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {
    private TicTacToeGame game;

    @BeforeEach
    public void setUp() {
        game = new TicTacToeGame();
    }
    @Test
    public void testInitialBoardIsEmpty() {
        char [][] board = game.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals('-', board[i][j]);
            }
        }
    }

    @Test
    public void testMakeValidMove() {
        assertTrue(game.makeMove(0, 0));
        assertEquals('x', game.getBoard()[0][0]);
        assertFalse(game.isPlayer1Turn()); // should switch to player 2
    }

    @Test
    public void testMakeInvalidMove() {
        game.makeMove(0, 0);
        assertFalse(game.makeMove(0, 0)); // trying to make a move in an occupied cell
        assertFalse(game.makeMove(3, 3)); // trying to make a move outside the board
    }

    @Test
    public void testHorizontalWin() {
        game.makeMove(0, 0); // x
        game.makeMove(1, 0); // o
        game.makeMove(0, 1); // x
        game.makeMove(1, 1); // o
        game.makeMove(0, 2); // x
        assertEquals('x', game.checkWinner()); // player 1 should win
    }

    @Test
    public void testVerticalWin() {
        game.makeMove(0, 0); // x
        game.makeMove(0, 1); // o
        game.makeMove(1, 0); // x
        game.makeMove(1, 1); // o
        game.makeMove(2, 0); // x
        assertEquals('x', game.checkWinner()); // player 1 should win
    }

    @Test
    public void testDiagonalWin() {
        game.makeMove(0, 0); // x
        game.makeMove(0, 1); // o
        game.makeMove(1, 1); // x
        game.makeMove(1, 0); // o
        game.makeMove(2, 2); // x
        assertEquals('x', game.checkWinner()); // player 1 should win
    }

    @Test
    public void testTieCondition() {
        game.makeMove(0, 0); // x
        game.makeMove(0, 2); // o
        game.makeMove(0, 1); // x
        game.makeMove(1, 0); // o
        game.makeMove(1, 2); // x
        game.makeMove(1, 1); // o
        game.makeMove(2, 0); // x
        game.makeMove(2, 1); // o
        game.makeMove(2, 2); // x
        assertEquals('T', game.checkWinner()); // should be a tie
    }

    @Test
    public void testCurrentPlayerTurn() {
        assertTrue(game.isPlayer1Turn());
        game.makeMove(0, 0);
        assertFalse(game.isPlayer1Turn()); // should switch to player 2
    }
}
