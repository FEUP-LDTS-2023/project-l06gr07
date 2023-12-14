package org.crazytracks.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Boolean.TRUE;

public class Surfer extends Element{
    private double surferSpeed;
    private final double maxSurferSpeed = 25;
    private int score = 0;
    private List<Integer> scoreDisplayList;

    private int score_multiplier = 1;
    private boolean multiplierOn;
    private int currentLane = 1;
    boolean isAlive = TRUE;

    private int multiplierSteps = 0;

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
        this.multiplierOn = false;
        this.scoreDisplayList = new ArrayList<>();

        this.surferSpeed = 5;
        startAcceleration();
    }

    private void startAcceleration(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                increaseSurferSpeed();
                if (surferSpeed < maxSurferSpeed){
                    startAcceleration();
                }
            }
        }, 5000);
    }
    private void increaseSurferSpeed(){
        this.surferSpeed += 1;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void increaseScore(int score, int score_multiplier){
        Integer scoreInc = score * score_multiplier;
        this.score += scoreInc;
        if (scoreInc > 2){
            scoreDisplayList.add(scoreInc);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    scoreDisplayList.remove(0);
                }
            }, 1000);
        }
    }

    public int getMultiplier() {
        return score_multiplier;
    }
    public boolean getMultiplierState(){
        return multiplierOn;
    }

    public void setMultiplier(int multiplier) {
        this.score_multiplier = multiplier;
        if (score_multiplier > 1) {
            multiplierOn();
        } else {
            multiplierOff();
        }
    }

    private void multiplierOn(){
        this.multiplierOn = true;
    }
    private void multiplierOff(){
        this.multiplierOn = false;
    }
    public void collectCoin(Coin coin){
        Integer scoreInc = coin.getCoinValue();
        increaseScore(scoreInc, score_multiplier);
    }

    public int getCurrentLane() {
        return currentLane;
    }

    public void setMultiplierSteps(int multiplierSteps) {
        this.multiplierSteps = multiplierSteps;
    }

    public int getMultiplierSteps() {
        return multiplierSteps;
    }

    public void decreaseMultiplierSteps() {
        this.multiplierSteps--;
    }

    public void resetMultiplierSteps() {
        this.multiplierSteps = 0;
    }

    public List<Integer> getScoreDisplayList() {
        return scoreDisplayList;
    }

    public double getSurferSpeed(){
        return surferSpeed;
    }

    public double getMaxSurferSpeed(){
        return maxSurferSpeed;
    }
}
