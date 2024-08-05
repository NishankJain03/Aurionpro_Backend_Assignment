package com.assignment.test;
import java.util.Scanner;
import com.assignment.model.PigGameCalisthenics;
import java.util.Random;

public class Pig_Game_Calisthenics_Test {
	PigGameCalisthenics pigGameCalisthenics = new PigGameCalisthenics();
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    public void startGame() {
        System.out.println("Let's Play");
        while (!pigGameCalisthenics.hasWon()) {
            playTurn();
        }
        System.out.println("You have finished in " + pigGameCalisthenics.getTurnCount() + " turns");
        scanner.close();
    }

    private void playTurn() {
        pigGameCalisthenics.setTurnCount();
        pigGameCalisthenics.setTurnScore();
        System.out.println("\nTURN " + pigGameCalisthenics.getTurnCount());
        boolean turnOver = false;
        while (!turnOver) {
            System.out.println("Roll or hold? (r/h): ");
            String choiceInput = scanner.next();
            char choice = choiceInput.charAt(0);
            usersChoice(choice);
            turnOver = shouldEndTurn(choice);
        }
    }

    private void usersChoice(char choice) {
        if (choice == 'r') {
            handleRoll();
            return;
        }
        if (choice == 'h') {
            handleHold();
            return;
        }
        System.out.println("Invalid input");
    }

    private boolean shouldEndTurn(char choice) {
        if (choice == 'r' && pigGameCalisthenics.getTurnScore() == 0) {
            return true;
        }
        if (choice == 'h' || pigGameCalisthenics.hasWon()) {
            return true;
        }
        return false;
    }

    private void handleRoll() {
        int die = random.nextInt(6) + 1;
        System.out.println("Die " + die);
        if (die == 1) {
            dieRollOne();
            return;
        }
        dieRollGreaterThanOne(die);
    }

    private void dieRollOne() {
        System.out.println("Score turns to zero");
        pigGameCalisthenics.setTurnScore();
    }

    private void dieRollGreaterThanOne(int die) {
        pigGameCalisthenics.addTurnScore(die);
        System.out.println("Turn score: " + pigGameCalisthenics.getTurnScore());
        if (pigGameCalisthenics.getTurnScore() + pigGameCalisthenics.getTotalScore() >= 20) {
            pigGameCalisthenics.addToTotalScore();
            System.out.println("Score for turn " + pigGameCalisthenics.getTurnScore());
            System.out.println("Total score " + pigGameCalisthenics.getTotalScore());
            System.out.println("You Won");
        }
    }

    private void handleHold() {
        pigGameCalisthenics.endTurn();
        System.out.println("Score for turn " + pigGameCalisthenics.getTurnScore());
        System.out.println("Total score " + pigGameCalisthenics.getTotalScore());
        if (pigGameCalisthenics.hasWon()) {
            System.out.println("You Won");
        }
    }

    public static void main(String[] args) {
        Pig_Game_Calisthenics_Test pigGameStart = new Pig_Game_Calisthenics_Test();
        pigGameStart.startGame();
    }
}
