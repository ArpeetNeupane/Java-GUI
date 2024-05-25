import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;

public class Gravity {
    private JFrame loadingFrame;
    private JPanel loadingPanel;
    private JProgressBar progressBar;
    private JLabel progressLabel;
    private Timer timer;
    private int progress;
    private JLabel imageLabel;
    private int yPosition;
    private int yVelocity;
    private final int gravity = 1;
    private final int bounceDamping = 10;
    private Timer animationTimer;

    public Gravity() {
        loadingFrame = new JFrame("Loading");
        loadingFrame.setSize(800, 600);
        loadingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadingFrame.setLayout(null);
        loadingFrame.setLocationRelativeTo(null);

        // Create panel for loading screen
        loadingPanel = new JPanel();
        loadingPanel.setBackground(new Color(240, 240, 240));
        loadingPanel.setBounds(0, 0, 800, 400); // setting bounds
        loadingPanel.setLayout(null); // setting layout to null

        // Loading the image from system
        ImageIcon imageIcon = new ImageIcon("../Game Design Images/gameLogoBright.jpg");
        Image image = imageIcon.getImage().getScaledInstance(500, 350, Image.SCALE_SMOOTH); // better image scaling algorithm

        // Creating a JLabel with the image
        imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setBounds(180, 100, 450, 250);

        // Setting initial position for animation
        yPosition = -imageLabel.getHeight();
        yVelocity = 20; // Initial falling speed
        imageLabel.setBounds(180, yPosition, 450, 250);

        // Creating a JLabel for the popping label
        JLabel poppingLabel = new JLabel("Going  With  The  Flow!");
        poppingLabel.setFont(new Font("Karate", Font.PLAIN, 30));
        poppingLabel.setForeground(new Color(16, 23, 32, 0)); // starting with transparency/opacity 0
        poppingLabel.setBounds(260, 360, 400, 30);

        // Adding the popping label to the loadingPanel
        loadingPanel.add(poppingLabel);

        // Creating a timer to gradually increase the label's visibility
        Timer poppingTimer = new Timer(30, new ActionListener() {
            int visibilityIndex = 0; // initial alpha value at 0

            @Override
            public void actionPerformed(ActionEvent e) {
                visibilityIndex += 3; // increasing visibilityIndex value for transparency every time ActionListener is fired(every 30 millisecond)
                if (visibilityIndex >= 255) { // when fully visible
                    visibilityIndex = 255; // setting alpha to max
                    ((Timer) e.getSource()).stop(); // stopping the timer, by tracking the source, which in this case is object of Timer
                }
                poppingLabel.setForeground(new Color(16, 23, 32, visibilityIndex)); // Update label color with new alpha
            }
        });
        // starting the popping animation timer
        poppingTimer.start();

        // Creating progress bar
        progressBar = new JProgressBar();
        progressBar.setValue(0);
        progressBar.setForeground(Color.BLACK);
        progressBar.setBounds(100, 450, 600, 30);

        // Creating label that shows progress in numbers
        progressLabel = new JLabel("0%");
        progressLabel.setHorizontalAlignment(SwingConstants.CENTER);
        progressLabel.setForeground(new Color(16, 23, 32));
        progressLabel.setFont(new Font("Arial", Font.BOLD, 20));
        progressLabel.setBounds(0, 500, 800, 30);

        // Adding components to the panel
        loadingPanel.add(imageLabel);

        // Adding components to the frame
        loadingFrame.add(loadingPanel);
        loadingFrame.add(progressBar);
        loadingFrame.add(progressLabel);

        // Using class InGameCursor on the panel for custom cursor and since the method is static, one doesn't need to create an instance
        InGameCursor.setCustomCursor(loadingPanel);

        // Configuring the progress timer
        timer = new Timer(169, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progress += (int) (Math.random() * 10);
                if (progress > 100) {
                    progress = 100;
                    timer.stop(); // stopping the timer if 100 is reached    
                    // Closing the loadingFrame after a delay of 550 milliseconds
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

        // Configuring the animation timer for the falling and bouncing effect
        animationTimer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update position and velocity
                yPosition += yVelocity;
                yVelocity += gravity;

                // Check for bounce
                if (yPosition + imageLabel.getHeight() > loadingPanel.getHeight()) {
                    yPosition = loadingPanel.getHeight() - imageLabel.getHeight();
                    yVelocity = -yVelocity + bounceDamping; // Reverse and dampen the velocity
                }

                // Update the image label position
                imageLabel.setLocation(180, yPosition);
            }
        });

        animationTimer.start();
    }

    public void startLoading() {
        progress = 0;
        timer.start();
        loadingFrame.getContentPane().setBackground(new Color(240, 240, 240)); // setting background color to black, getContentPane used to follow design principles, for consistency as well as for cross-platform compatibility
        loadingFrame.setVisible(true);
    }

    private void mainGUI() {
        JFrame mainFrame = new JFrame("Game");
        mainFrame.setSize(800, 550);

        JPanel panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(800, 550));

        // Using class InGameCursor on the panel for custom cursor and since the method is static, you don't need to create an instance
        InGameCursor.setCustomCursor(panel);

        // Loading the background image
        ImageIcon backgroundImageIcon = new ImageIcon("../Game Design Images/8BitCastle.jpg");
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(800, 550, Image.SCALE_DEFAULT);
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setBounds(0, 0, 800, 550);
        panel.add(backgroundLabel);

        // Adding options over the background image
        JLabel titleLabel = new JLabel("LOBOTOMY  KAISEN");
        titleLabel.setFont(new Font("Karate", Font.BOLD, 53));
        titleLabel.setForeground(Color.WHITE); // setting text color
        titleLabel.setBounds(140, 450, 700, 60); // setting bounds for positioning
        backgroundLabel.add(titleLabel); // adding the label to the background label(over image)

        // Creating buttons to go forward with the game
        // New game button
        JButton startGame = new JButton("NEW GAME");
        startGame.setFont(new Font("Karate", Font.PLAIN, 33));
        startGame.setBounds(275, 60, 240, 55);
        startGame.setForeground(Color.BLACK);
        startGame.setBackground(new Color(30, 50, 90, 255)); // transparency of 255(max)
        startGame.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)); // border type
        startGame.setFocusPainted(false); // removing the dotted border around text of button which appears when it is clicked
        backgroundLabel.add(startGame); // adding button to image bg

        // Continue game button
        JButton continueGame = new JButton("CONTINUE");
        continueGame.setFont(new Font("Karate", Font.PLAIN, 33));
        continueGame.setBounds(275, 130, 240, 55);
        continueGame.setForeground(Color.BLACK);
        continueGame.setBackground(new Color(30, 50, 90, 255)); // transparency of 255
        continueGame.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)); // border type
        continueGame.setFocusPainted(false); // removing the dotted border around text of button which appears when it is clicked
        backgroundLabel.add(continueGame); // adding button to image bg

        // Load game button
        JButton loadGame = new JButton("LOAD");
        loadGame.setFont(new Font("Karate", Font.PLAIN, 33));
        loadGame.setBounds(275, 200, 240, 55);
        loadGame.setForeground(Color.BLACK);
        loadGame.setBackground(new Color(30, 50, 90, 255)); // transparency of 255
        loadGame.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)); // border type
        loadGame.setFocusPainted(false); // removing the dotted border around text of button which appears when it is clicked
        backgroundLabel.add(loadGame); // adding button to image bg

        // Options button
        JButton optionsButton = new JButton("OPTIONS");
        optionsButton.setFont(new Font("Karate", Font.PLAIN, 33));
        optionsButton.setBounds(275, 270, 240, 55);
        optionsButton.setForeground(Color.BLACK);
        optionsButton.setBackground(new Color(30, 50, 90, 255)); // transparency of 255
        optionsButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)); // border type
        optionsButton.setFocusPainted(false); // removing the dotted border around text of button which appears when it is clicked
        backgroundLabel.add(optionsButton); // adding button to image bg

        // Exit game button
        JButton exitButton = new JButton("EXIT");
        exitButton.setFont(new Font("Karate", Font.PLAIN, 33));
        exitButton.setBounds(275, 340, 240, 55);
        exitButton.setForeground(Color.BLACK);
        exitButton.setBackground(new Color(30, 50, 90, 255)); // transparency of 255
        exitButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)); // border type
        exitButton.setFocusPainted(false); // removing the dotted border around text of button which appears when it is clicked
        backgroundLabel.add(exitButton); // adding button to image bg

        mainFrame.add(panel);
        mainFrame.setTitle("Game");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        Gravity loading = new Gravity();
        loading.startLoading();
    }
}