package org.crazytracks.model;

import static java.lang.Boolean.TRUE;

public class Surfer extends Element{

    private int score = 0;

    private int score_multiplier = 1;

    private int currentLane = 1;

    boolean isAlive = TRUE;

    public void setCurrentLane(int currentLane) {
        this.currentLane = currentLane;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }


    public Surfer(Position position) {
        super(position);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void increaseScore(int score, int score_multiplier){
        this.score+= score*score_multiplier;
    }

    public int getMultiplier() {
        return score_multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.score_multiplier = multiplier;
    }

    public void collectCoin(){
        this.score += 100;
    }

    public int getCurrentLane() {
        return currentLane;
    }
}
