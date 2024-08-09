package com.aurionpro.model;

import javax.swing.event.CellEditorListener;

public class ResultAnalyzer {
	private Board board;
	private ResultType resultType ;
	public ResultAnalyzer(Board board) {
		super();
		this.board = board;
		this.resultType = ResultType.PROGRESS;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public ResultType getResultType() {
		return resultType;
	}
	public void setResultType(ResultType resultType) {
		this.resultType = resultType;
	}
	
	private void horizontalWinCheck() {
		for (int row = 0; row < 3; row++) {
            int startIndex = row * 3;
            MarkType first = board.getCells()[startIndex].getMarkType();
            if (first != MarkType.EMPTY &&
                first == board.getCells()[startIndex + 1].getMarkType() &&
                first == board.getCells()[startIndex + 2].getMarkType()) {
                resultType = ResultType.WIN;
                return;
            }
        }
	}
	
	private void verticalWinCheck() {
		for (int col = 0; col < 3; col++) {
            int startIndex = col;
            MarkType first = board.getCells()[startIndex].getMarkType();
            if (first != MarkType.EMPTY &&
                first == board.getCells()[startIndex + 3].getMarkType() &&
                first == board.getCells()[startIndex + 6].getMarkType()) {
                resultType = ResultType.WIN;
                return;
            }
        }
	}
	private void diagonalWinCheckLeft() {
		MarkType first = board.getCells()[0].getMarkType();
        if (first != MarkType.EMPTY &&
            first == board.getCells()[4].getMarkType() &&
            first == board.getCells()[8].getMarkType()) {
            resultType = ResultType.WIN;
        }
	}
	private void diagonalWinCheckRight() {
		MarkType first = board.getCells()[2].getMarkType();
        if (first != MarkType.EMPTY &&
            first == board.getCells()[4].getMarkType() &&
            first == board.getCells()[6].getMarkType()) {
            resultType = ResultType.WIN;
        }
	}
	
	public ResultType analyseResult() {
		horizontalWinCheck();
        if (resultType == ResultType.WIN) return resultType;

        verticalWinCheck();
        if (resultType == ResultType.WIN) return resultType;

        diagonalWinCheckLeft();
        if (resultType == ResultType.WIN) return resultType;

        diagonalWinCheckRight();
        if (resultType == ResultType.WIN) return resultType;

        if (board.isBoardFull()) {
            resultType = ResultType.DRAW;
            return resultType;
        }
        resultType = ResultType.PROGRESS;

        return resultType;
	}
}




