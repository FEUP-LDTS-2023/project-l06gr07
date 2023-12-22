package org.crazytracks.gui.sui.mainsound;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.crazytracks.gui.sui.SUI;

import java.io.File;

public class MainSoundPlayer implements SUI {
    private MediaPlayer mediaPlayer;

    public MainSoundPlayer() {
        new JFXPanel();
    }

    @Override
    public void playMusic() {
        String filePath = "src/main/resources/sound/mainsounds/music.mp3";
        Media media = new Media(new File(filePath).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.5); // Set volume to 50%
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Loop indefinitely
        mediaPlayer.play();
    }
    @Override
    public void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}