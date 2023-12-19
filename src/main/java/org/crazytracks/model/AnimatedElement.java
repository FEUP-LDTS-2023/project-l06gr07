package org.crazytracks.model;

public abstract class AnimatedElement extends Element{
    private int animMode;
    private final int numOfAnimModes;
    public AnimatedElement(Position position, int numOfAnimModes) {
        super(position);

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
