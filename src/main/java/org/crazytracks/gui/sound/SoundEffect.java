package org.crazytracks.gui.sound;

public abstract class SoundEffect {
    private String filepath;

    public SoundEffect(String filepath){
        this.filepath = filepath;
    }

    public void play(){
        // play sound
    }
}
