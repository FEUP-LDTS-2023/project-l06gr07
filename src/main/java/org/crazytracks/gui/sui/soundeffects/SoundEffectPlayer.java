package org.crazytracks.gui.sui.soundeffects;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class SoundEffectPlayer implements SoundEffects, WagonCollisionListener, CoinCollisionListener, PowerUpCollisionListener {
    private MediaPlayer mediaPlayer;

    public SoundEffectPlayer() {
        new JFXPanel();
    }

    @Override
    public void onCoinCollision() {
        playSound("src/main/resources/sound/coin.mp3");
    }

    @Override
    public void onPowerUpCollision() {
        playSound("src/main/resources/sound/powerup.mp3");
    }

    @Override
    public void onWagonCollision() {
        playSound("src/main/resources/sound/wagon.mp3");
    }

    @Override
    public void playSound(String filePath) {
        Media sound = new Media(new File(filePath).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

}