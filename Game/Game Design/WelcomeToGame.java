import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.BorderFactory;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.SwingConstants;
import java.awt.RenderingHints;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.ButtonModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class WelcomeToGame {
    private JFrame loadingFrame;
    private JPanel loadingPanel;
    private JProgressBar progressBar;
    private JLabel progressLabel;
    private Timer timer;
    private int progress;

    public WelcomeToGame() {
        loadingFrame = new JFrame("Loading");
        loadingFrame.setSize(800, 600);
        loadingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadingFrame.setLayout(null);
        loadingFrame.setLocationRelativeTo(null);

        //create  panel for loading sreen
        loadingPanel = new JPanel();
        loadingPanel.setBackground(new Color(240, 240, 240));
        loadingPanel.setBounds(0, 0, 800, 400); //setting bounds
        loadingPanel.setLayout(null); //setting layout to null

        //loading the image from system
        ImageIcon imageIcon = new ImageIcon("../Game Design Images/gameLogoBright.jpg");
        Image image = imageIcon.getImage().getScaledInstance(500, 350, Image.SCALE_SMOOTH); //better image scaling algorithm
    
        //creating a JLabel with the image
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setBounds(180, 100, 450, 250);
        
        //creating a JLabel for the popping label
        JLabel poppingLabel = new JLabel("Going  With  The  Flow!");
        poppingLabel.setFont(new Font("Karate", Font.PLAIN, 30));
        poppingLabel.setForeground(new Color(16, 23, 32, 0)); //starting with transparency/opacity 0
        poppingLabel.setBounds(260, 360, 400, 30);
        
        //adding the popping label to the loadingPanel
        loadingPanel.add(poppingLabel);
        
        //creating a timer to gradually increase the label's visibility
        Timer poppingTimer = new Timer(30, new ActionListener() {
            int visibilityIndex = 0; //initial alpha value at 0
            @Override
            public void actionPerformed(ActionEvent e) {
                visibilityIndex += 3; //increasing visibilityIndex value for transparency every time ActionListener is fired(every 30 millisecond)
                if (visibilityIndex >= 255) { // when fully visible
                    visibilityIndex = 255; //setting alpha to max
                    ((Timer) e.getSource()).stop(); //stopping the timer, by tracking the source, which in this case is object of Timer
                }
                poppingLabel.setForeground(new Color(16, 23, 32, visibilityIndex)); // Update label color with new alpha
            }
        });
        //starting the popping animation timer
        poppingTimer.start();

        //creating progress bar
        progressBar = new JProgressBar();
        progressBar.setValue(0);
        progressBar.setForeground(Color.BLACK);
        progressBar.setBounds(100, 450, 600, 30);

        //creating label that shows progress in numbers
        progressLabel = new JLabel("0%");
        progressLabel.setHorizontalAlignment(SwingConstants.CENTER);
        progressLabel.setForeground(new Color(16, 23, 32));
        progressLabel.setFont(new Font("Arial", Font.BOLD, 20));
        progressLabel.setBounds(0, 500, 800, 30);
        
        //adding to panel
        loadingPanel.add(imageLabel);
        
        //adding to frame
        loadingFrame.add(loadingPanel);
        loadingFrame.add(progressBar);
        loadingFrame.add(progressLabel);
        
        //using class InGameCursor on the panel for custom cursor and since the method is static, one doesn't need to create an instance
        InGameCursor.setCustomCursor(loadingPanel);
        
        //configuring timer
        timer = new Timer(169, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progress += (int) (Math.random() * 10);
                if (progress > 100) {
                    progress = 100;
                    timer.stop(); //stopping the timer if 100 is reached    
                    //closing the loadingFrame after a delay of 550 milliseconds
                    Timer delayTimer = new Timer(550, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            loadingFrame.dispose();
                            mainGUI();
                        }
                    });
                    delayTimer.setRepeats(false);
                    delayTimer.start();
                }
                progressBar.setValue(progress);
                progressLabel.setText(String.valueOf(progress) + "%");
            }
        });
    }

    public void startLoading() {
        progress = 0;
        timer.start();
        loadingFrame.getContentPane().setBackground(new Color(240, 240, 240));//setting background color to black, getContentPane used to follow  
        //design principles, for consistency as well as for cross platfor compatibility
        loadingFrame.setVisible(true);
    }

    private void mainGUI() {
        JFrame mainFrame= new JFrame("Game");
        mainFrame.setSize(800, 550);
        
        JPanel panel = new JPanel(new FlowLayout());
        panel.setPreferredSize(new Dimension(800, 550));
        
        //using class InGameCursor on the panel for custom cursor and since the method is static, you dont need to create an instance
        InGameCursor.setCustomCursor(panel);

        //loading the background image
        ImageIcon backgroundImageIcon = new ImageIcon("../Game Design Images/8BitCastle.jpg");
        //a variable is created of object type ImageIcon which is a subclass of Image, takes path as argument
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(800, 550, Image.SCALE_DEFAULT);
        /*extracts image from backgroundImageIcon using get, then uses getScaledInstance() for scaling imaging to needed size, Image.SCALE_DEFAULT is
        the default scaling algorithm which maintains the aspect ratio and makes it so java uses most appropriate scaling algorithm 
        for the given context, ensuring optimal image quality and performance.*/
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        panel.add(backgroundLabel);
        
        //adding options over the background image
        JLabel titleLabel = new JLabel("LOBOTOMY  KAISEN");
        titleLabel.setFont(new Font("Karate", Font.BOLD, 53));
        titleLabel.setForeground(Color.WHITE); //setting text color
        titleLabel.setBounds(140, 450, 700, 60); //setting bounds for positioning
        backgroundLabel.add(titleLabel); //adding the label to the background label(over image)
        
        //creating buttons to go forward with the game
        //new game button
        JButton startGame = new JButton("NEW GAME");
        startGame.setFont(new Font("Karate", Font.PLAIN, 33));
        startGame.setBounds(275, 60, 240, 55);
        startGame.setForeground(Color.BLACK);
        startGame.setBackground(new Color(30, 50, 90, 255)); //transparency of 255(max)
        startGame.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)); //border type
        startGame.setFocusPainted(false); //removing the dotted border around text of button which appears when it is clicked
        backgroundLabel.add(startGame); //adding button to image bg
        
        //continue game button
        JButton continueGame = new JButton("CONTINUE");
        continueGame.setFont(new Font("Karate", Font.PLAIN, 33));
        continueGame.setBounds(275, 130, 240, 55);
        continueGame.setForeground(Color.BLACK);
        continueGame.setBackground(new Color(30, 50, 90, 255)); //transparency of 255
        continueGame.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)); //border type
        continueGame.setFocusPainted(false); //removing the dotted border around text of button which appears when it is clicked
        backgroundLabel.add(continueGame); //adding button to image bg
        
        //continue game by loading button
        JButton loadGame = new JButton("LOAD");
        loadGame.setFont(new Font("Karate", Font.PLAIN, 33));
        loadGame.setBounds(275, 200, 240, 55);
        loadGame.setForeground(Color.BLACK);
        loadGame.setBackground(new Color(30, 50, 90, 255)); //transparency of 255
        loadGame.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)); //border type
        loadGame.setFocusPainted(false); //removing the dotted border around text of button which appears when it is clicked
        backgroundLabel.add(loadGame); //adding button to image bg
        
        //options button
        JButton optionsButton = new JButton("OPTIONS");
        optionsButton.setFont(new Font("Karate", Font.PLAIN, 33));
        optionsButton.setBounds(275, 270, 240, 55);
        optionsButton.setForeground(Color.BLACK);
        optionsButton.setBackground(new Color(30, 50, 90, 255)); //transparency of 255
        optionsButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)); //border type
        optionsButton.setFocusPainted(false); //removing the dotted border around text of button which appears when it is clicked
        backgroundLabel.add(optionsButton); //adding button to image bg
        
        //exit game button
        JButton exitButton = new JButton("EXIT");
        exitButton.setFont(new Font("Karate", Font.PLAIN, 33));
        exitButton.setBounds(275, 340, 240, 55);
        exitButton.setForeground(Color.BLACK);
        exitButton.setBackground(new Color(30, 50, 90, 255)); //transparency of 255
        exitButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)); //border type
        exitButton.setFocusPainted(false); //removing the dotted border around text of button which appears when it is clicked
        backgroundLabel.add(exitButton); //adding button to image bg
        
        mainFrame.add(panel);
        mainFrame.setTitle("Game");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    public static void main(String[] args) {
        WelcomeToGame loading = new WelcomeToGame();
        loading.startLoading();
    }
}