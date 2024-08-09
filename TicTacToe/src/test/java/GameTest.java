import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
	
	private Board board;
    private ResultAnalyzer analyzer;
    private Player player1;
    private Player player2;
    private Game game;

    @BeforeEach
    public void init() {
        board = new Board();
        analyzer = new ResultAnalyzer(board);
        player1 = new Player("Alice", MarkType.X);
        player2 = new Player("Bob", MarkType.O);
        game = new Game(new Player[]{player1, player2}, board, analyzer);
    }
    
    @Test
    public void getCurrentPlayer() {
    	game.play(0);
    	
    	assertEquals(player2, game.getCurrentPlayer());
    }
}
