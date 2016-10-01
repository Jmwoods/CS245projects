/**************************************
*   file:Hangman.java
*   Authors:
*   Class: CS 245 - Graphical User Interface
* 
*   Assignment: Point and Click game v1.0
*   Date Last Modified: 
*   Purpose:
* 
***************************************/
package cs245;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Hangman {

    /**
     * The main method. All objects that are needed for the program to run are created here
     * @param args 
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
		try {                      
                    HangmanGUI game = new HangmanGUI();
		}
                catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
        
    }
}

