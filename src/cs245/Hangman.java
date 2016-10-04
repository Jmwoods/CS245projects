/**************************************
*   file:Hangman.java
*   @author Ervin Maulas Joel Woods Jose Garcia Alan Chen
*   Class: CS 245 - Graphical User Interface
* 
*   Assignment: Point and Click game 
*   @version v1.0
*   Date Last Modified: 3 October 2016
*   Purpose: Starts a game of hangman, with GUI elements. The user has 6 tries
*   to guess the word before the game is over. Maximum score is 100
* 
***************************************/
package cs245;

import java.util.Arrays;
import java.util.Random;
import javax.swing.SwingUtilities;


public class Hangman {
    /**
     * Word list needed for the hangman game.
     */
    final private String[] WORD_LIST = {"abstract", "cemetery", "nurse",
        "pharmacy", "climbing"};
    
    /**
     * Stores the correctly guessed letters for the hangman game.
     */
    private char[] lettersCorrect;
    
    /**
     * Stores the word chosen randomly from the word list.
     */
    private String word;
    
    /**
     * Stores the number of incorrect guesses, which cannot be >= 6.
     */
    private int numWrong;
    
    /**
     * Stores the current user score.
     */
    private int score;
    
    
    public Hangman(){
        score = 100;
        numWrong = 0;
        pickWord();       
    }
    /**
     * Checks if the letter passed in is contained in the word
     * @param letter letter to be checked
     * @return whether the word contained the letter
     */
    public boolean checkWord(String letter){
        boolean correctGuess = false;
        for(int a = 0; a < word.length(); a++){
            if(letter.charAt(0) == word.charAt(a)){
                lettersCorrect[a]= letter.charAt(0);
                correctGuess = true;
            }
        }
        //If the word didn't have the letter, substracts from the score and 
        //adds to the current number of incorrect guesses
        if(correctGuess == false){
            score -= 10;
            numWrong++;
        }
        return correctGuess;
    }
    /**
     * Returns correctly guessed letters
     * @return char array with the current guessed word
     */
    public char[] getCurrentGuess(){
        return lettersCorrect;
    }
    /**
     * Checks if the user can continue the game
     * @return the state of the game
     */
    public boolean checkGameOver(){
        return (numWrong == 6 || Arrays.toString(lettersCorrect).equals(word));
    }
    /**
     * Score of the game
     * @return score
     */
    public int getScore(){
        return score;
    }
    /**
     * Resets the hangman game.
     */
    public void reset(){
        score = 100;
        numWrong = 0;
        pickWord();
    }
    /**
     * Picks a word at random from the word list, and initializes a matching
     * character array.
     */
    private void pickWord(){
        Random random = new Random(); 
        word = WORD_LIST[random.nextInt(5)];
        lettersCorrect = new char[word.length()];
        for(int a = 0; a < lettersCorrect.length; a++){
            lettersCorrect[a] = '_';
        }
    }
    /** 
     * Method: Main
     * The main method. Starts the Hangman GUI
     * @param args command line arguments (not used) 
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
		try {                      
                    HangmanGUI game = new HangmanGUI();
		}
                catch (Exception e) {
                    System.err.println(e);
		}
            }
	});
        
    }
}

