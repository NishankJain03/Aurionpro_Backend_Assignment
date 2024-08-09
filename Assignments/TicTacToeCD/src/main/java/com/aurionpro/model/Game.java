package com.aurionpro.model;

public class Game {
	private Player[] players;
	private Board board;
	private ResultAnalyzer analyzer;
	private Player currentPlayer;
	private ResultType resultType = ResultType.PROGRESS;
	public Game(Player[] players, Board board, ResultAnalyzer analyzer) {
		super();
		this.players = players;
		this.board = board;
		this.analyzer = analyzer;
		this.currentPlayer = players[0];
	}

	public void play(int loc) {
		if(resultType != ResultType.PROGRESS) {
			System.out.println("game already over");
			return;
		}
		try {
			if(board.getCells()[loc].isEmpty()) {
				board.setCellMark(loc, currentPlayer.getMarkType());
				resultType = analyzer.analyseResult();
				if(resultType == ResultType.PROGRESS) {
					switchCurrentPlayer();
				}else {
					System.out.println("game over" + resultType);
				}
			}else {
				System.out.println("cell already marked");
			}
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Invalid cell location" + e.getMessage());
		}
	}
	private void switchCurrentPlayer() {
		currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
	}
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public ResultType getResult() {
		return resultType;
	}
	
	public Board getBoard() {
		return board;
	}
	
}
