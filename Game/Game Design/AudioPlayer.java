import javax.sound.sampled.*;
import java.io.*;

public class AudioPlayer {
    private static Clip music; //clip is a class in package "javax.sound.sampled.*" that represents a sound that can be played.
    private static Clip clickSound;

    public static void playMusic(String audioFilePath) {
        try {
            File audioFile = new File(audioFilePath);
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(audioFile);
            music = AudioSystem.getClip();
            music.open(audioInput);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    public static void playBg() {
        if (music != null) {
            music.setFramePosition(0); //setting the playback position of the Clip to the beginning (frame position 0); rewinding it to the start.
            music.start();
        }
    }

    public static void stopBg() {
        if (music != null && music.isRunning()) {
            music.stop();
        }
    }
    
    public static void buttonClickSounds(String audioFilePath) {
        try {
            File clickSoundFile = new File(audioFilePath);
            AudioInputStream clickInput = AudioSystem.getAudioInputStream(clickSoundFile);
            clickSound = AudioSystem.getClip();
            clickSound.open(clickInput);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void playSFX() {
        if (clickSound != null) {
            clickSound.setFramePosition(0); //setting the playback position of the Clip to the beginning (frame position 0); rewinding it to the start.
            clickSound.start();
        }
    }

    public static void stopSFX() {
        if (clickSound != null && clickSound.isRunning()) {
            clickSound.stop();
        }
    }
}
