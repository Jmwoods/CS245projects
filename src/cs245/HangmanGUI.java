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
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class HangmanGUI extends JFrame implements ActionListener{
    
    private static final int WINDOW_LENGTH = 600;
    
    private static final int WINDOW_WIDTH = 400;
    
    private int score;
    
    private JLabel title, teamName;
    
    private JButton play, highScore, credits, back, skip, end;
    
    private JButton[] letterButton;
    
    private JPanel mainPanel, menuPanel, gamePanel, letterPanel, displayMainPanel,
            displayPanel;
    
    private Hangman hangman;
    
    private Timer timer;
    
    
    /**
     * Creates the objects needed for the game to reach the main menu.
     */
    public HangmanGUI(){
        super("CS 245 Hangman v1.0");
        hangman = new Hangman();
        initializeWindow();
        endScreen();
//mainMenu();
//          gameScreen();
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
     * Will create objects needed to show the credit or high score screen.
     * @param isCredits needed to determine whether the screen will print credit
     * or high score elements
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
            displayPanel.add(createLabel("Credits", 46, Color.red));
            displayPanel.add(createLabel("Ervin Maulas, 008873462", 22, Color.BLACK));
            displayPanel.add(createLabel("Joel Woods, 000000000", 22, Color.BLACK));
            displayPanel.add(createLabel("Jose Garcia, 000000000", 22, Color.BLACK));
            displayPanel.add(createLabel ("Alan Chen, 000000000", 22, Color.BLACK));            
        }
        else{
            displayPanel = new JPanel(new GridLayout(6,1));
            displayPanel.add(createLabel("High Scores", 40, Color.GREEN));
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
        getContentPane().setBackground(Color.BLACK);       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_LENGTH, WINDOW_WIDTH);
        //this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
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
    /**
     * Creates the buttons needed for the hangman game.
     */
    private void initLetterButtons(){
        char letter = 'A';
        letterButton = new JButton[26];
        for(int a = 0; a < 26; a++){
            letterButton[a] = new JButton(Character.toString(letter++));
            letterButton[a].addActionListener(this);
        }      
    }
    /**
     * Creates the objects needed to display the hangman game GUI.
     */
    private void gameScreen(){
        gamePanel = new JPanel(new BorderLayout());
        JPanel centerGamePanel = new JPanel(new BorderLayout());
        gamePanel.add(centerGamePanel, BorderLayout.CENTER);
        JPanel wordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        
        for(int a = 0; a < 5; a++){
            wordPanel.add(createLabel("_", 46, Color.black));
        }
        centerGamePanel.add(wordPanel, BorderLayout.PAGE_END);
        this.add(gamePanel);
        JPanel topPanel = new JPanel();
        topPanel.add(createLabel("Hangman", 36, Color.green), FlowLayout.LEFT);
        initLetterButtons();
        JPanel tt = new JPanel(new GridLayout(2,13));
        for(JButton j : letterButton){
            tt.add(j);
        }
        gamePanel.add(topPanel, BorderLayout.PAGE_START);
        gamePanel.add(tt, BorderLayout.PAGE_END);
    }
    /**
     * Game over screen which prints the user score.
     */
    private void endScreen(){
        hangman.reset(); //Resets variables for hangman game
        JPanel endPanel = new JPanel(new GridLayout(5,1));
        this.add(endPanel);
        endPanel.add(new JLabel()); //Blank JLabel used for formatting
        endPanel.add(createLabel("GAME OVER", 46, Color.RED));
        endPanel.add(new JLabel());//Black Jlabel used for formatting
        endPanel.add(createLabel(Integer.toString(score), 30, Color.BLACK));
        JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT));
        back = new JButton("back");
        back.addActionListener(this);
        left.add(back);
        this.add(left, BorderLayout.PAGE_END);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        
        //Returns the user to the main menu
        if(button == back || button == end){
            getContentPane().removeAll();
            mainMenu();
            getContentPane().validate();
            getContentPane().repaint();
        }
        //Navigates to the hangman game screen
        else if(button == play){
            getContentPane().removeAll();
            gameScreen();
            getContentPane().validate();
            getContentPane().repaint();
            //do nothing
        }
        //Navigates to the high score screen
        else if(button == highScore){
            getContentPane().remove(mainPanel);
            creditsOrHighScoreScreen(false);
            getContentPane().validate();
            getContentPane().repaint();
        }
        //Navigates to the credit screen
        else if(button == credits){
            getContentPane().remove(mainPanel);
            creditsOrHighScoreScreen(true);
            getContentPane().validate();
            getContentPane().repaint();

        }
        //Navigates to the game over screen; sets score to 0
        else if (button == skip){
            score = 0;
            getContentPane().removeAll();
            endScreen();
            getContentPane().validate();
            getContentPane().repaint(); 
        }
        //Condition is used for any letter button action in hangman game
        else{
            System.out.println(button.getText());
            //button.setEnabled(false);            
            if (hangman.checkGameOver()){
                score = hangman.getScore();
                getContentPane().removeAll();
                endScreen();
                getContentPane().validate();
                getContentPane().repaint();             
            }
        }
    }
    
}
