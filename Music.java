package Classes;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Music {
    Clip clip;
    Clip loop;
    void playMusic(String musicLocation) {
                try {
                    clip = AudioSystem.getClip();
                    File file = new File(musicLocation);
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.out.println(e);
                }

    }
    void loopMusic(String musicLocation) {
        try {
            loop = AudioSystem.getClip();
            File file = new File(musicLocation);
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
            loop.open(inputStream);
            loop.start();
            loop.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    void stopLoop(){
        if (loop != null) {
            loop.stop();
            loop.close();
        }
        loop=null;
    }
}
