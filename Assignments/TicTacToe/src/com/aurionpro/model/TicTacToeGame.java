package com.aurionpro.model;

public class TicTacToeGame {
    private char[][] board;
    private boolean player1Turn;

    public TicTacToeGame() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            printColumnDash(i);
        }
        player1Turn = true;
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
        char winner = playerHasWon();
        if (winner == 'x' || winner == 'o') {
            return winner;
        }
        return boardIsFull() ? 'T' : ' ';
    }

    private char playerHasWon() {
        // Checking rows
        for (int i = 0; i < 3; i++) {
        	char winner = checkRow(i);
            if (winner != ' ') {
                return winner;
            }
        }
        // Checking columns
        for (int i = 0; i < 3; i++) {
        	char winner = checkColumn(i);
        	if (winner != ' ') {
                return winner;
            }
        }

        // Checking diagonals
        char winner = checkDigonalLeft();
        if (winner != ' ') {
            return winner;
        }
        
        char winner1 = checkDiagonalRight();
        if (winner1 != ' ') {
            return winner1;
        }

        return ' ';
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
    
    public void printColumnDash(int i) {
    	for (int j = 0; j < 3; j++) {
            board[i][j] = '-';
        }
    }
    
    public char checkRow(int i) {
    	if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
            return board[i][0];
        }
    	return ' '; 
    }
    
    public char checkColumn(int i) {
    	if (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
    		System.out.println(board[0][i]);
            return board[0][i];
        }
    	return ' ';
    }
    
    public char checkDigonalLeft() {
    	if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }
    	return ' ';
    }
    
    public char checkDiagonalRight() {
    	if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }
    	return ' ';
    }
}
