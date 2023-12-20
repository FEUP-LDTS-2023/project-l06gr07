package org.crazytracks.model;

public class Animation {
    private int animMode;
    private final int numOfAnimModes;
    public Animation(int numOfAnimModes) {
        this.animMode = 0;
        this.numOfAnimModes = numOfAnimModes;
    }
    public int getAnimMode(){
        return animMode;
    }
    public void nextAnimMode(){
        this.animMode = (this.animMode + 1)%numOfAnimModes;
    }

}