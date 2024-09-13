package com.mycompany.espgame;

import java.util.*;
import javax.swing.JOptionPane;

public class ESPGame {

    // Main method to start the game and display total wins
    public static void main(String[] args) {
        int wins;
        
        wins = comparer();
        JOptionPane.showMessageDialog(null, "Total wins: " + wins);
    }

    // Method to randomly select a color
    public static String computerChoice() {
        int randomNumber;
        String computerChoice = "";
        Random random = new Random();

        randomNumber = random.nextInt(5) + 1;

        switch (randomNumber) {
            case 1:
                computerChoice = "Red";
                break;
            case 2:
                computerChoice = "Green";
                break;
            case 3:
                computerChoice = "Blue";
                break;
            case 4:
                computerChoice = "Orange";
                break;
            case 5:
                computerChoice = "Yellow";
                break;
        }

        return computerChoice;
    }

    // Method to get the human player's color choice
    public static String humanChoice() {
        String humanChoice = JOptionPane.showInputDialog("Enter a color name (Red, Green, Blue, Orange, Yellow)");

        while (humanChoice.isEmpty()) {
            humanChoice = JOptionPane.showInputDialog("Input can't be empty. Enter a color name (Red, Green, Blue, Orange, Yellow)");
        }
        return humanChoice;
    }
    
    // Method to compare human and computer choices over 10 rounds and count wins
    public static int comparer() {
        int wins = 0;
        int index = 1;
        
        while(index <= 10) {
            String humanChoice = humanChoice(); // Human's choice for this round
            String compChoice = computerChoice(); // Computer's choice for this round
            
            String resultMessage = "Round " + index + ":\n" +
                                   "Human choice: " + humanChoice + "\n" +
                                   "Computer choice: " + compChoice + "\n";
            
            if(humanChoice.equalsIgnoreCase(compChoice)) {
                resultMessage += "You won this round!";
                wins++;
            } else {
                resultMessage += "You lost this round.";
            }
            
            JOptionPane.showMessageDialog(null, resultMessage);
            index++;
        }
        
        return wins;
    }
}
