

import java.util.Scanner;

public class GameApp {

	public static void main(String[] args) {
		Player player1 = new Player("alice" , MarkType.X);
		Player player2 = new Player("bob", MarkType.O);
		
		Board board = new Board();
		ResultAnalyzer analyzer = new ResultAnalyzer(board);
		
		Game game = new Game(new Player[]{player1,player2}, board, analyzer);
		Scanner scanner = new Scanner(System.in);
		
		int loc;
		while(game.getResult() == ResultType.PROGRESS) {
			System.out.println("Current board layout");
			displayBoard(board);
			System.out.println(game.getCurrentPlayer().getName() + " 's turn enter a slot 0-8");
			loc = scanner.nextInt();
			game.play(loc);
		}
		scanner.close();

	}
	
	private static void displayBoard(Board board) {
		for(int i=0;i<9;i++) {
			if(i%3 == 0) {
				System.out.println();
			}
			MarkType markType = board.getCells()[i].getMarkType();
			System.out.print(markType == MarkType.EMPTY ? " _ " : markType );
			System.out.print(" "); 
		}
		System.out.println();
	}

}
