package com.assignment.model;

public class PigGameCalisthenics {
    private int totalScore;
    private int turnScore;
    private int turnCount;

    public PigGameCalisthenics() {
        this.totalScore = 0;
        this.turnScore = 0;
        this.turnCount = 0;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getTurnScore() {
        return turnScore;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public void setTurnCount() {
        turnCount++;
    }

    public void setTurnScore() {
        turnScore = 0;
    }

    public void addTurnScore(int score) {
        turnScore += score;
    }

    public void addToTotalScore() {
        totalScore += turnScore;
    }

    public void endTurn() {
        totalScore += turnScore;
    }

    public boolean hasWon() {
        return totalScore >= 20;
    }
}
