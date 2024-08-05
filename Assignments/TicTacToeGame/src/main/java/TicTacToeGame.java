
public class TicTacToeGame {
    private char[][] board;
    private boolean player1Turn;

    public TicTacToeGame() {
        board = new char[3][3];
        initializeBoard();
        player1Turn = true;
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || col < 0 || row >= 3 || col >= 3 || board[row][col] != '-') {
            return false;
        }
        board[row][col] = player1Turn ? 'x' : 'o';
        player1Turn = !player1Turn;
        return true;
    }

    public char checkWinner() {
        // Check rows, columns, and diagonals for a winner
        char winner = checkRowsAndColumns();
        if (winner != ' ') {
            return winner;
        }
        return checkDiagonals();
    }

    private char checkRowsAndColumns() {
        for (int i = 0; i < 3; i++) {
            char rowWinner = checkRow(i);
            if (rowWinner != ' ') {
                return rowWinner;
            }
            char colWinner = checkColumn(i);
            if (colWinner != ' ') {
                return colWinner;
            }
        }
        return ' ';
    }

    private char checkRow(int i) {
        if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
            return board[i][0];
        }
        return ' ';
    }

    private char checkColumn(int i) {
        if (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
            return board[0][i];
        }
        return ' ';
    }

    private char checkDiagonals() {
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }
        return boardIsFull() ? 'T' : ' ';
    }

    private boolean boardIsFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public char[][] getBoard() {
        return board;
    }

    public boolean isPlayer1Turn() {
        return player1Turn;
    }
}
