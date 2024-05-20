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

public class MainScreen {
    private JFrame loadingFrame;
    private JPanel loadingPanel;
    private JProgressBar progressBar;
    private JLabel progressLabel;
    private Timer timer;
    private int progress;

    public MainScreen() {
        loadingFrame = new JFrame("Loading");
        loadingFrame.setSize(1800, 1000);
        loadingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadingFrame.setLayout(new FlowLayout());
        loadingFrame.getContentPane().setBackground(Color.BLACK); //setting background color to black, getContentPane used to follow design principles, 
        //for consistency as well as for cross platfor compatibility
        loadingFrame.setLocationRelativeTo(null); //centers the frame on the screen
        
        loadingPanel = new JPanel()
        {
            @Override //overriding in-built method
            protected void paintComponent(Graphics g) {
                //paintComponent(Graphics g) is an in-built method which is responsible for painting or drawing the visual representation of the component
                //protected so that it may only be accessed/used by sub-classes or in the same package
                super.paintComponent(g);
                //good practice to use super to call the superclass's version of that method before adding your custom code.
                //the paintComponent(Graphics g) method of JPanel is responsible for painting the panel's background and any other default behavior related 
                //to drawing. By calling super.paintComponent(g), it is ensured that this default behavior is executed before any custom drawing code.
                
                //casting Graphics to Graphics2D to enable advanced rendering
                Graphics2D g2d = (Graphics2D)g;

                //enabling anti-aliasing for smooth text rendering
                g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

                //load the "Karate" font directly as it is installed in the system
                Font karateFont = new Font("Karate", Font.BOLD, 50);
                g2d.setFont(karateFont);

                //drawing "Welcome!" text using the "Karate" font
                g2d.setColor(Color.WHITE);
                g2d.drawString("Welcome!", 290, 150);
            }
        };
        loadingPanel.setPreferredSize(new Dimension(800, 600));
        loadingPanel.setBackground(new Color(16, 23, 32)); //different color; bluish dark black
        loadingFrame.add(loadingPanel);
        
        //using class InGameCursor on the panel for custom cursor and since the method is static, no need to create an instance
        InGameCursor.setCustomCursor(loadingPanel);

        progressBar = new JProgressBar();
        progressBar.setValue(0); //setting the initial value to 0
        progressBar.setStringPainted(false); //hiding percentage
        progressBar.setBackground(Color.BLACK); //setting background color to black
        progressBar.setForeground(new Color(242, 242, 242)); //setting filling color of loading bar to gold
        loadingFrame.add(progressBar);

        progressLabel = new JLabel("0"); //initial progress of loading in number
        progressLabel.setHorizontalAlignment(SwingConstants.CENTER);
        progressLabel.setForeground(Color.WHITE); //setting color of loaded percentage in numbers to white
        progressLabel.setFont(new Font("Arial", Font.BOLD, 20));
        loadingFrame.add(progressLabel);

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progress += (int) (Math.random() * 10);
                if (progress > 100) {
                    progress = 100;
                    timer.stop();
                    // Close the loading frame after a delay of 550 miliseconds (2000-3000 milliseconds)
                    Timer delayTimer = new Timer(550, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            loadingFrame.dispose();
                            mainGUI();
                        }
                    });
                    delayTimer.setRepeats(false); // Only execute once
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

        // Add the background label to the panel
        panel.add(backgroundLabel);
        
        mainFrame.add(panel);
        mainFrame.setTitle("Game");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        MainScreen loading = new MainScreen();
        loading.startLoading();
    }
}
