import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Dimension;

public class SizeExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Size Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton preferredButton = new JButton("Preferred Size");
        preferredButton.setPreferredSize(new Dimension(150, 50));

        JButton fixedButton = new JButton("Fixed Size");
        fixedButton.setSize(150, 50);

        frame.add(preferredButton);
        frame.add(fixedButton);

        frame.pack();
        frame.setVisible(true);
    }
}
