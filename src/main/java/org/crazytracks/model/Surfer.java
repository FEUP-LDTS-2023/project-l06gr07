package org.crazytracks.model;

public class Surfer extends Element{

    private int score = 0;

    private int score_multiplier = 1;

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
}
