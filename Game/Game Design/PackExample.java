import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class PackExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pack Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");

        frame.add(button1);
        frame.add(button2);

        // Use pack() to size the frame
        frame.pack();
        frame.setVisible(true);
    }
}
