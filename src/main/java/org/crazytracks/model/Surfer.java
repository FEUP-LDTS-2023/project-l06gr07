package org.crazytracks.model;

public class Surfer extends Element{

    private int score = 0;

    private int score_multiplier = 1;

    private int currentLane = 1;

    public void setCurrentLane(int currentLane) {
        this.currentLane = currentLane;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    boolean isAlive = true;

    public Surfer(Position position) {
        super(position);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void increaseScore(){
        this.score++;
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
