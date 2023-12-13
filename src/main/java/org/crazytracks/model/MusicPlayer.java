package org.crazytracks.model;

import javax.sound.sampled.*;
import java.util.Objects;

public class MusicPlayer {
    private Clip clip;

    public void playFromResource(String resourcePath) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getResourceAsStream(resourcePath)));

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);

            clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | LineUnavailableException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}