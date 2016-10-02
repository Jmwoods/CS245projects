/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author ejm
 */
public class HangmanGUI extends JFrame implements ActionListener{
    
    private static final int WINDOW_LENGTH = 600;
    
    private static final int WINDOW_WIDTH = 400;
    
    private JLabel title, teamName;
    
    private JButton play, highScore, credits, back, skip;
    
    private JPanel mainFrame, gameFrame, letterFrame;
    
    private Timer timer;
    
    public HangmanGUI(){
        super("CS 245 Hangman");
        initializeWindow();
        startScreen();
        mainMenu();
               
    }
    private void startScreen(){
        title = new JLabel("CS 245 Hangman v1.0", JLabel.CENTER);
        title.setFont(new Font("Comic Sans MS",Font.BOLD, 42));
        title.setForeground(Color.white);
        teamName = new JLabel("Team: Default_Username", JLabel.CENTER);
        teamName.setFont(new Font("Comic Sans MS",Font.BOLD, 20));
        teamName.setForeground(Color.white);
        this.add(title, BorderLayout.PAGE_START);
        this.add(teamName, BorderLayout.CENTER);
    }
    
    private void mainMenu(){
        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        //right.setBackground(Color.BLACK);
        mainFrame = new JPanel(new GridLayout(3,1));
        right.add(mainFrame);
        mainFrame.setBackground(Color.black);
        //mainFrame.setOpaque(false);
        play = new JButton("Play");
        highScore = new JButton("High Score");
        credits = new JButton("Credits");
        mainFrame.add(play);
        mainFrame.add(credits);
        mainFrame.add(highScore);
        this.add(right, BorderLayout.PAGE_END);   
    }

    private void initializeWindow(){
        this.getContentPane().setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_LENGTH, WINDOW_WIDTH);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(0,100));
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();
    }
    
}
