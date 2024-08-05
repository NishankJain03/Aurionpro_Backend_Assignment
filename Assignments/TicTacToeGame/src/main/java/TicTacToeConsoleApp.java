
import java.util.Scanner;

public class TicTacToeConsoleApp {
    private TicTacToeGame game;
    private Scanner scanner;

    public TicTacToeConsoleApp() {
        game = new TicTacToeGame();
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("TIC TAC TOE Game");
        System.out.print("Enter the name, player 1: ");
        String p1 = scanner.next();
        System.out.print("Enter the name, player 2: ");
        String p2 = scanner.next();

        boolean hasEnded = false;

        while (!hasEnded) {
            printBoard();
            System.out.println(game.isPlayer1Turn() ? p1 + " turn (x)" : p2 + " turn (o)");

            int row = -1, col = -1;
            takeInput();

            char result = game.checkWinner();
            hasEnded = checkResult(p1, p2, result);
        }
        printBoard();
    }

    private void printBoard() {
        char[][] board = game.getBoard();
        for (int i = 0; i < 3; i++) {
            System.out.print(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2] + " ");
            if (i < 2) {
                System.out.println();
                System.out.println("-----------");
            }
        }
        System.out.println();
    }

    private void takeInput() {
        while (true) {
            System.out.print("Enter the row number (0-2): ");
            int row = scanner.nextInt();
            System.out.print("Enter the column number (0-2): ");
            int col = scanner.nextInt();
            if (game.makeMove(row, col)) {
                break;
            }
            System.out.println("Invalid move. Try again.");
        }
    }

    private boolean checkResult(String p1, String p2, char result) {
        if (result == 'x') {
            System.out.println(p1 + " has won!");
            return true;
        }
        if (result == 'o') {
            System.out.println(p2 + " has won!");
            return true;
        }
        if (result == 'T') {
            System.out.println("It's a tie!");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TicTacToeConsoleApp app = new TicTacToeConsoleApp();
        app.startGame();
    }
}
