import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

public class MainScreenExample extends JFrame {
    public MainScreenExample() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.setPreferredSize(new Dimension(950, 600));
        
        //using class InGameCursor on the panel for custom cursor and since the method is static, you dont need to create an instance
        InGameCursor.setCustomCursor(panel);

        //loading the background image
        ImageIcon backgroundImageIcon = new ImageIcon("D:/Arpeet/College/Programming/java programming/Game Design Images/8BitCastle.jpg");
        //a variable is created of object type ImageIcon which is a subclass of Image, takes path as argument
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(950, 600, Image.SCALE_DEFAULT);
        /*extracts image from backgroundImageIcon using get, then uses getScaledInstance() for scaling imaging to needed size, Image.SCALE_DEFAULT is
        the default scaling algorithm which maintains the aspect ratio and makes it so java uses most appropriate scaling algorithm 
        for the given context, ensuring optimal image quality and performance.*/
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));

        // Add the background label to the panel
        panel.add(backgroundLabel);
        
        add(panel);
        setTitle("Loading Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MainScreenExample();
    }
}
