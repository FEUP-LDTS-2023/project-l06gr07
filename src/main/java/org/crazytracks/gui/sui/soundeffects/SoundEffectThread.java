package org.crazytracks.gui.sui.soundeffects;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundEffectThread extends Thread{
    private String filePath;

    public SoundEffectThread(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        play(filePath);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        interrupt();
    }

    public void play(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(-10.0f);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException();
        }
    }
}
