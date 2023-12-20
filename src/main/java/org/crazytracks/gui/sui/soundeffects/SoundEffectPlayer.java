package org.crazytracks.gui.sui.soundeffects;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundEffectPlayer implements SoundEffects, WagonCollisionListener, CoinCollisionListener, PowerUpCollisionListener{
    @Override
    public void onCoinCollision() {
        playSound("src/main/resources/sound/coinSoundEffect.wav");
    }
    @Override
    public void onPowerUpCollision() {

    }
    @Override
    public void playSound(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(-20.0f);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onWagonCollision() {

    }
}
