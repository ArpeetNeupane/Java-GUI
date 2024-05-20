import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.SwingConstants;
import java.awt.RenderingHints;
import java.awt.FlowLayout;

public class WelcomeToGameBeta {
    private JFrame loadingFrame;
    private JPanel loadingPanel;
    private JProgressBar progressBar;
    private JLabel progressLabel;
    private Timer timer;
    private int progress;

    public WelcomeToGameBeta() {
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

        //creating welcome label
        JLabel welcomeLabel = new JLabel("LOBOTOMY  KAISEN");
        welcomeLabel.setFont(new Font("Karate", Font.BOLD, 40));
        welcomeLabel.setForeground(new Color(16, 23, 32));
        welcomeLabel.setBounds(190, 130, 450, 150);

        //creating progress bar
        progressBar = new JProgressBar();
        progressBar.setValue(0);
        progressBar.setBounds(100, 450, 600, 30);

        //creating label that shows progress in numbers
        progressLabel = new JLabel("0");
        progressLabel.setHorizontalAlignment(SwingConstants.CENTER);
        progressLabel.setForeground(new Color(16, 23, 32));
        progressLabel.setFont(new Font("Arial", Font.BOLD, 20));
        progressLabel.setBounds(0, 500, 800, 30);
        
        //adding to panel
        loadingPanel.add(welcomeLabel);
        
        //adding to frame
        loadingFrame.add(loadingPanel);
        loadingFrame.add(progressBar);
        loadingFrame.add(progressLabel);

        //configuring timer
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progress += (int) (Math.random() * 10);
                if (progress > 100) {
                    progress = 100;
                    timer.stop();
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
                progressLabel.setText(String.valueOf(progress));
            }
        });
    }

    public void startLoading() {
        progress = 0;
        timer.start();
        loadingFrame.getContentPane().setBackground(new Color(240, 240, 240)); //setting background color
        loadingFrame.setVisible(true);
    }

    private void mainGUI() {
        JFrame mainFrame= new JFrame("Game");
        mainFrame.setSize(800, 600);
        
        JPanel panel = new JPanel(new FlowLayout());
        panel.setPreferredSize(new Dimension(800, 600));
        
        //using class InGameCursor on the panel for custom cursor and since the method is static, you dont need to create an instance
        InGameCursor.setCustomCursor(panel);

        //loading the background image
        ImageIcon backgroundImageIcon = new ImageIcon("D:/Arpeet/College/Programming/java programming/Game Design Images/8BitCastle.jpg");
        //a variable is created of object type ImageIcon which is a subclass of Image, takes path as argument
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        /*extracts image from backgroundImageIcon using get, then uses getScaledInstance() for scaling imaging to needed size, Image.SCALE_DEFAULT is
        the default scaling algorithm which maintains the aspect ratio and makes it so java uses most appropriate scaling algorithm 
        for the given context, ensuring optimal image quality and performance.*/
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));

        panel.add(backgroundLabel);
        
        mainFrame.add(panel);
        mainFrame.setTitle("Game");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        WelcomeToGameBeta loading = new WelcomeToGameBeta();
        loading.startLoading();
    }
}
