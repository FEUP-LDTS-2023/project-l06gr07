package org.crazytracks.gui.sui.mainsound;

import org.crazytracks.gui.sui.SUI;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class CompatibilitySoundPlayer implements SUI {
    private Clip backgroundMusic;

    @Override
    public void playMusic() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/sound/music.wav").getAbsoluteFile());
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audioInputStream);
            FloatControl volume = (FloatControl) backgroundMusic.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(-20.0f);
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stopMusic() {
        if (backgroundMusic != null && backgroundMusic.isRunning()) {
            backgroundMusic.stop();
        }
    }
}
