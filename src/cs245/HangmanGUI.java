/**************************************
*   file:HangmanGUI.java
*   @author Ervin Maulas, Joel Woods, Jose Garcia, Alan Chen
*   Class: CS 245 - Graphical User Interface
* 
*   Assignment: Point and Click game 
*   @version v1.0
*   Date Last Modified: 1 October 2016
*   Purpose: Creates the GUI elements that the user will interact with
* 
***************************************/
package cs245;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class HangmanGUI extends JFrame implements ActionListener{
    
    private static final int WINDOW_LENGTH = 600;
    
    private static final int WINDOW_WIDTH = 400;
    
    private JLabel title, teamName, creditLabel, name1, name2, name3, name4;
    
    private JButton play, highScore, credits, back, skip;
    
    private JPanel mainPanel, menuPanel, gamePanel, letterPanel, displayMainPanel,
            displayPanel;
    
    private Timer timer;
    /**
     * Creates the objects needed for the game to reach the main menu.
     */
    public HangmanGUI(){
        super("CS 245 Hangman");
        initializeWindow();
        mainMenu();          
    }
    /**
     * Creates the objects needed to display the initial start screen, and adds
     * them to the frame.
     */
    private void startScreen(){       
        title = createLabel("CS 245 Hangman v1.0", 42, Color.white);
        teamName = createLabel("Team: Default_Username", 20, Color.white);
        this.add(title, BorderLayout.PAGE_START);
        this.add(teamName, BorderLayout.CENTER);
    }
    /**
     * Creates the objects needed to display the main menu, and adds them to the
     * frame.
     * @TODO Change GridLayout to BoxLayout
     */
    private void mainMenu(){
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);
        this.add(mainPanel);
        
        JPanel right = new JPanel(new GridLayout(2,1));
        right.setOpaque(false);
        menuPanel = new JPanel(new GridLayout(3,1));
        JPanel test = new JPanel();
        test.setOpaque(false);
        right.add(test);
        right.add(menuPanel);
        menuPanel.setOpaque(false);
        play = new JButton("Play");
        play.addActionListener(this);
        highScore = new JButton("High Score");
        highScore.addActionListener(this);
        credits = new JButton("Credits");
        credits.addActionListener(this);
        menuPanel.add(play);
        menuPanel.add(credits);
        menuPanel.add(highScore);
        mainPanel.add(right, BorderLayout.LINE_END);   
    }
    /**
     * Will create objects needed to show the credit screen.
     */
    
    private void creditsOrHighScoreScreen(boolean isCredits){
        displayMainPanel = new JPanel(new BorderLayout());
        JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT));
        back = new JButton("back");
        back.addActionListener(this);
        left.add(back);
        displayMainPanel.add(left, BorderLayout.PAGE_END);
        creditsOrHighScore(isCredits);
        this.add(displayMainPanel);
    }
    /**
     * Populates a generic panel with back button with either the credits or 
     * high score.
     * @param isCredits stores boolean which decides which elements to populate
     * panel with
     * @TODO Change GridLayout to BoxLayout
     */
    private void creditsOrHighScore(boolean isCredits){
        if(isCredits){
            displayPanel = new JPanel(new GridLayout(5,1));
            creditLabel = createLabel("Credits", 46, Color.red);
            displayPanel.add(creditLabel);
            name1 = createLabel("Ervin Maulas, 008873462", 22, Color.BLACK);
            displayPanel.add(name1);
            name2 = createLabel("Joel Woods, 000000000", 22, Color.BLACK);
            displayPanel.add(name2);
            name3 = createLabel("Jose Garcia, 000000000", 22, Color.BLACK);
            displayPanel.add(name3);
            name4 = createLabel ("Alan Chen, 000000000", 22, Color.BLACK);
            displayPanel.add(name4);            
        }
        else{
            displayPanel = new JPanel(new GridLayout(6,1));
            displayPanel.add(createLabel("High Scores", 46, Color.GREEN));
            for(int i = 0; i < 5; i++){
                displayPanel.add(createLabel("ABC.....000", 22, Color.BLACK));   
            }
            
        }
        displayMainPanel.add(displayPanel, BorderLayout.CENTER);
    }
    /**
     * Adds the attributes for the JFrame created for the game.
     */
    private void initializeWindow(){
//        mainPanel = new JPanel(new BorderLayout());
//        mainPanel.setBackground(Color.BLACK);
        getContentPane().setBackground(Color.BLACK);       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_LENGTH, WINDOW_WIDTH);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
//        this.add(mainPanel);
    }
    /**
     * Creates the specific labels needed for the hangman game
     * @param text text to be displayed by the label
     * @param size the size of the text for the label
     * @param color color of the text for the label
     * @return label object with correct settings for game elements
     */
    private JLabel createLabel(String text, int size, Color color){
        JLabel tempLabel = new JLabel(text, JLabel.CENTER);
        tempLabel.setFont(new Font("Comic Sans MS",Font.BOLD, size));
        tempLabel.setForeground(color);
        return tempLabel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();
        if(object == back){
            getContentPane().remove(displayMainPanel);
            mainMenu();
            getContentPane().validate();
            getContentPane().repaint();
        }
        else if(object == play){
            //do nothing
        }
        else if(object == highScore){
            getContentPane().remove(mainPanel);
            creditsOrHighScoreScreen(false);
            getContentPane().validate();
            getContentPane().repaint();
        }
        else if(object == credits){
            getContentPane().remove(mainPanel);
            creditsOrHighScoreScreen(true);
            getContentPane().validate();
            getContentPane().repaint();

        }
        else{
            //do nothing
        }
    }
    
}
