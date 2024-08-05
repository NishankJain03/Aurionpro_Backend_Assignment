import java.util.Scanner;

public class TicTacToeMain {

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            printBoard(game);
            
            // Get the current player's move
            char currentPlayer = game.getCurrentPlayer();
            System.out.println("Player " + currentPlayer + "'s turn.");
            System.out.print("Enter row and column (0, 1, or 2) separated by space: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            
            // Attempt to make the move
            boolean validMove = game.markBoard(row, col, currentPlayer);
            
            if (!validMove) {
                System.out.println("Invalid move. Try again.");
                continue;
            }
            
            // Check for a win or a draw
            if (game.checkWin()) {
                printBoard(game);
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }
            
            if (game.isDraw()) {
                printBoard(game);
                System.out.println("The game is a draw!");
                break;
            }
        }
        
        scanner.close();
    }

    private static void printBoard(TicTacToe game) {
        char[][] board = game.getBoard();
        System.out.println("Current board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] == '\0' ? '.' : board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("--+---+--");
        }
    }
}
