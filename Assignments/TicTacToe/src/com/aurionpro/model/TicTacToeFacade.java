package com.aurionpro.model;

import java.util.Scanner;

public class TicTacToeFacade {
    private TicTacToeGame game;
    private Scanner scanner;

    public TicTacToeFacade() {
        game = new TicTacToeGame();
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("TIC TAC TOE Game");
        System.out.println("Enter the name, player 1");
        String p1 = scanner.next();
        System.out.println("Enter the name, player 2");
        String p2 = scanner.next();

        boolean hasEnded = false;

        while (!hasEnded) {
            printBoard();
            System.out.println(game.isPlayer1Turn() ? p1 +  " turn (x)" : p2 +" turn (o)");
            
            int row = -1, col = -1;
            takeInput(row, col);

            char result = game.checkWinner();
            boolean isEnd = checkResult(p1, p2, result);
            if(isEnd)
            	hasEnded = true;
        }
        printBoard();
    }

    private void printBoard() {
        char[][] board = game.getBoard();
        for (int i = 0; i < 3; i++) {
        	System.out.print(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2] + " ");
        	printDash(i);
        }
        System.out.println();
    }
    
    public void takeInput(int row, int col) {
    	while (true) {
            System.out.println("Enter the row number");
            row = scanner.nextInt();
            System.out.println("Enter the column number");
            col = scanner.nextInt();
            if (game.makeMove(row, col)) {
                break;
            } 
            System.out.println("Invalid move. Try again.");
        }
    }
    
    public boolean checkResult(String p1, String p2, char result) {
    	
        if (result == 'x') {
            System.out.println( p1 + " has won!");
            return true;
        }
        if (result == 'o') {
            System.out.println( p2 + " has won!");
            return true;
        }
        if (result == 'T') {
            System.out.println("It's a tie!");
            return true;
        }
        return false;
    }
    
    public void printDash(int i) {
    	if (i < 2) {
            System.out.println();
            System.out.println("-----------");
        }
    }
}
