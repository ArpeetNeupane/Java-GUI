import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class InGameFont {
    public static Font loadFont() {
        Font customFont = null;
        try {
            //loading the custom font from a file, fonts are usually ttf(truetypefont)
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("D:/Arpeet/College/Programming/java programming/Game Design Font/karate/Karate.ttf"));
        } 
        catch (IOException | FontFormatException e) {
            // Handle font loading errors
            e.printStackTrace();
        }
        return customFont;
    }
}
