import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.event.ActionListener;

public class InGameCursor {
    public static void setCustomCursor(JComponent component) { //parameter component which accepts any subclass of JComponent such asJPanel
        //since method doesn't rely on instance specific task, it is cast as static and the class can be called directly whenever it is needed
        //loading custom cursor image from the system
        BufferedImage/*class*/ circleCursor = null;
        try {
            circleCursor = ImageIO.read(new File("../Game Design Images/circleCursor2.png"));
        } catch (IOException e) {
            e.printStackTrace();//exact exception and where it occured, from where it occured
        }
        
        //creating the custom cursor and setting up the hotspot
        if (circleCursor != null) { //if properly loaded
            Cursor coolCursor = Toolkit.getDefaultToolkit().createCustomCursor(circleCursor, new Point(10, 10), "Custom Cursor");
            //getDefaultToolkit() extracts windows default cursor, createCustomCursor() creates new cursor according to passed arguments
            //new Point(x, y), tyo cursor ko kun point(pixel) chai main-point ho; where click garda event hune, pixel starts from 0
            component.setCursor(coolCursor); //inbuilt method setCursor
        }
    }
}

