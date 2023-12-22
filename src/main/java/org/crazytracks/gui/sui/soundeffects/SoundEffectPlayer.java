package org.crazytracks.gui.sui.soundeffects;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundEffectPlayer implements SoundEffects, WagonCollisionListener, CoinCollisionListener, PowerUpCollisionListener {
    private MediaPlayer mediaPlayer;

    public SoundEffectPlayer() {
        new JFXPanel();
    }

    @Override
    public void onCoinCollision() {
        try {
            playSound("src/main/resources/sound/mainsounds/coin.mp3");
        } catch (Exception e) {
            compatPlaySound("src/main/resources/sound/compatsounds/coinSoundEffect.wav");
        }
    }

    @Override
    public void onPowerUpCollision() {
        try {
            playSound("src/main/resources/sound/mainsounds/powerup.mp3");
        } catch (Exception e) {
            compatPlaySound("src/main/resources/sound/compatsounds/powerUpSoundEffect.wav");
        }
    }

    @Override
    public void onWagonCollision() {
        try {
            playSound("src/main/resources/sound/mainsounds/wagon.mp3");
        } catch (Exception e) {
            compatPlaySound("src/main/resources/sound/compatsounds/wagonSoundEffect.wav");
        }
    }

    @Override
    public void playSound(String filePath) {
        Media sound = new Media(new File(filePath).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    public void compatPlaySound(String filePath) {
        SoundEffectThread soundThread = new SoundEffectThread(filePath);
        soundThread.start();
    }

}