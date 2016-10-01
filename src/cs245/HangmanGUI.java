/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author ejm
 */
public class HangmanGUI extends JFrame{
    
    private static final int WINDOW_LENGTH = 600;
    
    private static final int WINDOW_WIDTH = 400;
    
    private JLabel title, teamName;
    
    private JButton play, highScore, credits, back, skip;
    
    public HangmanGUI(){
        super("CS 245 Hangman");
        initializeWindow();
        title = new JLabel("CS 245 Hangman v1.0", JLabel.CENTER);
        title.setFont(new Font("Comic Sans MS",Font.BOLD, 36));
        teamName = new JLabel("Team: Default_Username", JLabel.CENTER);
        teamName.setFont(new Font("Comic Sans MS",Font.BOLD, 16));
        this.add(title, BorderLayout.NORTH);
        this.add(teamName, BorderLayout.CENTER);
      
    }

    private void initializeWindow(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_LENGTH, WINDOW_WIDTH);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}
