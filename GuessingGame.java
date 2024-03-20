//This program is supposed to allow the user to play a guessing game

//Name: Pierce Coyle

//Date: 1/9/2024  

//Class: CS &141

//Assignment:  Lab # 1 Guessing game

//Purpose: Playing a guessing game 

//Import scanner and random
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        final int MAXRANGE = 100;
        int guesses = 0;
        int sumOfGuesses = 0;
        int gamesPlayed = 0;
        int bestGame = 10000;
        String answer;
        boolean canContinue = true;

        intro();
        //while loop that plays multiple games and prompts the user if they want to play again
        while (canContinue == true) {
            gamesPlayed += 1;
            guesses = playGame(MAXRANGE);
            if (guesses < bestGame) {
                bestGame = guesses;
             }
             sumOfGuesses += guesses;
             System.out.printf("%s", "Would you like to play again? ");
             answer = scan.next();
             if (answer.startsWith("y") || answer.startsWith("Y")) {
                canContinue = true;
             } else  {
                canContinue = false;
             }
        }
        statReport(bestGame, sumOfGuesses, gamesPlayed);
        System.out.print("Thanks for playing!");
    //End of main
    }
   
    public static void intro() { //Prints an intro for the user
        System.out.println("This program allows you to play a guessing game.");
        System.out.println("Give me a range and I will think of a number.");
        System.out.println("I will allow you to guess until you get it.");
        System.out.println("For each guess, I will tell you whether the");
        System.out.println("right answer is higher or lower than your guess.");
    //End of intro
    }

    public static int playGame(int MAXRANGE) { //Plays through a single game
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        
        boolean isWrong = true;
        int guesses = 0;
        int randomNum;
        int userGuess;

        randomNum = random.nextInt(MAXRANGE) + 1;
        System.out.println("I'm thinking of a number between 1 and " + (MAXRANGE) +"...");
        //While loop to prompt again given a wrong answer
        while (isWrong == true) {
            System.out.print("Your guess? ");
            //try/ catch statement in-case the user enters a string
            try {
                userGuess = scan.nextInt();
                if (userGuess == randomNum && guesses == 0) {
                    System.out.println("You got it right in 1 guess.");
                    isWrong = false;
                } else if (userGuess == randomNum && guesses > 0) {
                    System.out.println("You got it right in " + (guesses+1) + " guesses.");
                    isWrong = false;
                } else if (userGuess > randomNum) {
                    System.out.println("It's lower.");
                } else {
                    System.out.println("It's Higher.");
                }
            } catch (Exception e) {
                System.out.println("That guess is invalid.");
                scan.next();
                guesses -=1;
            }
            guesses += 1;
        }
        return guesses;
    //End of playGame
    }

    public static void statReport( int bestGame, int sumOfGuesses, int gamesPlayed) { //Reports the users stats after they're done playing
        double avg = (double) sumOfGuesses / gamesPlayed;
        System.out.printf("%s\n", "Overall results:");
        System.out.printf("%-4s%-14s%-2s%d\n", "", "total games ", "=", gamesPlayed);
        System.out.printf("%-4s%-14s%-2s%d\n", "", "total guesses ", "=", sumOfGuesses);
        System.out.printf("%-4s%-14s%-2s%.1f\n", "", "guesses/game ", "=", avg);
        System.out.printf("%-4s%-14s%-2s%d\n", "", "best game ", "=", bestGame);
    //End of statReport
    }
















}