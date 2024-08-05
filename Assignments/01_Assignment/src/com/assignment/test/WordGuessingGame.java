package com.assignment.test;


import java.util.Scanner;
import java.util.Random;

public class WordGuessingGame {
    public static void main(String[] args) {
        // List of words to guess
        String[] words = {"programming", "java", "developer", "software", "computer"};
        
        Random random = new Random();
        String wordToGuess = words[random.nextInt(words.length)];
        
        int wordLength = wordToGuess.length();
        int attempts = wordLength * 3;
        char[] guessedWord = new char[wordLength];
        for (int i = 0; i < wordLength; i++) {
            guessedWord[i] = '_';
        }
        
        Scanner scanner = new Scanner(System.in);
        boolean wordGuessed = false;
        
        while (attempts > 0 && !wordGuessed) {
            System.out.println("Word to guess: " + new String(guessedWord));
            System.out.println("Attempts remaining: " + attempts);
            System.out.print("Guess a letter: ");
            char guessedLetter = scanner.next().charAt(0);
            
            boolean letterFound = false;
            for (int i = 0; i < wordLength; i++) {
                if (wordToGuess.charAt(i) == guessedLetter) {
                    guessedWord[i] = guessedLetter;
                    letterFound = true;
                }
            }
            
            if (!letterFound) {
                attempts--;
            }
            
            wordGuessed = true;
            for (int i = 0; i < wordLength; i++) {
                if (guessedWord[i] == '_') {
                    wordGuessed = false;
                    break;
                }
            }
        }
        
        if (wordGuessed) {
            System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
        } else {
            System.out.println("Game Over! You've run out of attempts. The word was: " + wordToGuess);
        }
        
        scanner.close();
    }
}
