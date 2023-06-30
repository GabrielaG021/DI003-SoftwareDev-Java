/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.gabrielag.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Gabriela Gutierrez
 */
public class Rockpaperscissors {

    public static void main(String[] args) {
        Scanner userReader = new Scanner(System.in);
        
        // Declare the variables
        String playerName;
        int maxNumRds = 10, minNumRds = 1; // User input must be between 1-10
        int numOfRds, currentRd = 1;
        int playerChoice, computerChoice;
        int rock = 1, paper = 2, scissors = 3;
        String resultPerRd;
        int tieCount=0, winCount=0, loseCount=0;
        String playAgainChoice = "y";
        boolean playAgainR = false, notCorrectA = false;
        
        // Ask player for his name
        System.out.println("Please, enter your name: ");
        playerName = userReader.nextLine();
        System.out.println(""); // Created for space between lines
        
        // Call method to display Welcome Message
        welcomeMessage(playerName);
        
        do {
            // Call method to get user choice of rounds to play
            numOfRds = getNumOfRounds();
            if(numOfRds > maxNumRds || numOfRds < minNumRds){ // Response out of range
                System.out.println("Invalid entry. This game is over when it hasn't even started.");
                System.out.println("Goodbye!");
                break;
            } else { // Response is withing range
                while(currentRd < numOfRds + 1){
                    playerChoice = playerChoiceRPS();
                    //System.out.println(playerChoice);
                    computerChoice = compChoiceRPS();
                    //System.out.println(computerChoice);
                    if(playerChoice == rock || playerChoice == paper || playerChoice == scissors){
                        resultPerRd = getWinner(playerChoice, computerChoice);
                        
                        if(resultPerRd.toLowerCase().startsWith("w")){
                            winCount++;
                        } else if(resultPerRd.toLowerCase().startsWith("l")){
                            loseCount++;
                        } else if(resultPerRd.toLowerCase().startsWith("t")){
                            tieCount++;
                        }
                        
                        // Count the number of rounds so far
                        currentRd++;
                    } else {
                        System.out.println("Invalid response entered! Start over.\n");
                    }
                }
            }
            
            // Call method to display final results
            System.out.println("");
            resultsDisplay(winCount, loseCount, tieCount);
            
            // Ask user if you want to play another match
            System.out.println("Start Over! Would you like to play a match again? (yes/no)");
            playAgainChoice = userReader.nextLine();
            
            if(playAgainChoice.toLowerCase().startsWith("y")){
                System.out.println("You are amazing, let's win this time!");
                // Setting back all of our variables to 0
                playAgainR = true;
                currentRd = 1;
                winCount = 0;
                loseCount = 0;
                tieCount = 0;
                notCorrectA = false;
            } else if(playAgainChoice.toLowerCase().startsWith("n")){
                playAgainR = false;
                notCorrectA = false;
                System.out.println("It was a pleasure. Thank you for playing!");
            } else {
                System.out.println("Invalid reponse, please try again.");
                notCorrectA = true;
            }
            
        }while(playAgainR == true);
        
    }
    
    public static void welcomeMessage(String playerName){
        System.out.println("Hi, " + playerName);
        System.out.println("Welcome to the Online Game of Rock, Paper, Scissors!");
        System.out.println("You are very brave to challenge a bot like me. Hahaha -.-");
        System.out.println(""); // Created for space between lines
        System.out.println("Like always, read below the set of directions and rules of how this game works:");
        System.out.println("  1 - Choose the number of rounds to play (1-10).");
        System.out.println("      **Warning: Game will exit if result is not within the range**");
        System.out.println("  2 - Choose Rock, paper, or scissors.");
        System.out.println("  3 - Bot will randomly choose Rock, paper, or scissors.");
        System.out.println("  4 - The program will record the results, print the stats and continue.");
        System.out.println("  5 - When rounds are up, the final result stats will be displayed to let you know how you did.");
        System.out.println("  6 - Game Over! You will have the option to play again.");
        System.out.println(""); // Created for space between lines
        System.out.println("Let's begin this game...");
        System.out.println(""); // Created for space between lines
    }
    
    public static int getNumOfRounds(){
        Scanner playerInput = new Scanner(System.in);
        
        System.out.println("How many rounds do you want to play? (1-10)");
        return playerInput.nextInt();
    }
    
    public static int playerChoiceRPS(){
        Scanner playerInput = new Scanner(System.in);
        
        System.out.println("Please pick a number choice: ");
        System.out.println("[1] = Rock");
        System.out.println("[2] = Paper");
        System.out.println("[3] = Scissors");
        
        return playerInput.nextInt();
    }
    
    public static int compChoiceRPS(){
        Random rand = new Random();
        return rand.nextInt(3) + 1;
    }
    
    public static String getWinner(int playerC, int compC){
        int rock = 1;
        int paper = 2;
        int scissors = 3;
        String result = "";
        
        if(playerC == compC){
            System.out.println("Player and Computer had the same choices");
            System.out.println("The game is a tie!");
            result = "tie";
        } else if(playerC == rock && compC == paper){
            System.out.println("Player chose " + playerC + " and Computer chose " + compC);
            System.out.println("Your rock got covered by the paper!");
            result = "lose";
        } else if(playerC == rock && compC == scissors) {
            System.out.println("Player chose " + playerC + " and Computer chose " + compC);
            System.out.println("Your rock smashed the scissors!");
            result = "win";
        } else if(playerC == paper && compC == rock){
            System.out.println("Player chose " + playerC + " and Computer chose " + compC);
            System.out.println("Your paper put to sleep the rock!");
            result = "win";
        } else if(playerC == paper && compC == scissors){
            System.out.println("Player chose " + playerC + " and Computer chose " + compC);
            System.out.println("Your paper got sliced by the evil scissors!");
            result = "lose";
        } else if(playerC == scissors && compC == rock){
            System.out.println("Player chose " + playerC + " and Computer chose " + compC);
            System.out.println("Your scissors got smashed by the rock!");
            result = "lose";
        } else if(playerC == scissors && compC == paper){
            System.out.println("Player chose " + playerC + " and Computer chose " + compC);
            System.out.println("Revenge! Your scissors sliced the paper!");
            result = "win";
        }
        return result;
    }
    
    public static void  resultsDisplay(int winCount, int loseCount, int tieCount){
        System.out.println(""); //Creates space between lines
        System.out.println("-----------------------------"); // 29 dashes
        System.out.println("--  FINAL RESULTS ARE IN!  --");
        System.out.println("-----------------------------\n\n");
        
        if(winCount > loseCount){
            System.out.println("Congrats! You won this game match.\n Killing it!");
        } else if(loseCount > winCount){
            System.out.println("Aww! Sorry you lost this game match.\n Game over!");
        } else {
            System.out.println("So so! Try again, you tied this game match.\n\n");
        }
        
        System.out.println(""); // Space needed for stats
        System.out.println("---    Round Statistics   ---\n");
        System.out.println("Tied: " + tieCount + " rounds");
        System.out.println("Win: " + winCount + " rounds");
        System.out.println("Lost: " + loseCount + " rounds");
    }
}
