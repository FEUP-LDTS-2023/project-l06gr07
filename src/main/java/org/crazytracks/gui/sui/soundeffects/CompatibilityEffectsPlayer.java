package org.crazytracks.gui.sui.soundeffects;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompatibilityEffectsPlayer implements SoundEffects, WagonCollisionListener, CoinCollisionListener, PowerUpCollisionListener{
    private List<Clip> playingClips = new ArrayList<>();
    @Override
    public void onCoinCollision() {
        playSound("src/main/resources/sound/coinSoundEffect.wav");
    }
    @Override
    public void onPowerUpCollision() {
        playSound("src/main/resources/sound/powerUpSoundEffect.wav");
    }
    @Override
    public void playSound(String filePath) {
        cleanup();
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(-10.0f);
            clip.start();
            playingClips.add(clip);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onWagonCollision() {
        playSound("src/main/resources/sound/wagonSoundEffect.wav");

    }
    public void cleanup() {
        playingClips.removeIf(clip -> clip.getFramePosition() >= clip.getFrameLength());
    }
}
