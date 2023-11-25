package org.crazytracks.model;

public class Surfer extends Element{

    private int score;
    public Surfer(Position position) {
        super(position);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
