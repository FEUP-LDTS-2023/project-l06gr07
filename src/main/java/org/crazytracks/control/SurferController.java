package org.crazytracks.control;

import org.crazytracks.Game;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.*;

import java.io.IOException;

public class SurferController extends GameController{
    public SurferController(Track model) {
        super(model);
    }
    private long lastScoreIncrease = System.currentTimeMillis();

    public void moveSurfer(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getSurfer().setPosition(position);
        }
        else if (getModel().getTrackElement(position) instanceof PowerUp) {
            getModel().getSurfer().setPosition(position);
            getModel().getSurfer().setMultiplier(getModel().getSurfer().getMultiplier() + 1);
            getModel().getSurfer().setMultiplierSteps(10*60);
            getModel().removeTrackElement(position);
        }
        else if (getModel().getTrackElement(position) instanceof Coin) {
            getModel().getSurfer().setPosition(position);
            getModel().getSurfer().collectCoin();
            getModel().removeTrackElement(position);
        }
        else if (getModel().getTrackElement(position) instanceof Wagon){
            getModel().getSurfer().setAlive(false);
        }

    }

    public void moveSurferLeft() {
        if (getModel().getSurfer().getCurrentLane() == 1 || getModel().getSurfer().getCurrentLane() == 2) {
            getModel().getSurfer().setCurrentLane(getModel().getSurfer().getCurrentLane() - 1);
            moveSurfer(getModel().getSurfer().getLeftPosition());
        }
    }

    public void moveSurferRight() {
        if (getModel().getSurfer().getCurrentLane() == 0 || getModel().getSurfer().getCurrentLane() == 1) {
            getModel().getSurfer().setCurrentLane(getModel().getSurfer().getCurrentLane() + 1);
            moveSurfer(getModel().getSurfer().getRightPosition());
        }
    }

    public void increaseScore(long time) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastScoreIncrease >= time) {
            getModel().getSurfer().increaseScore(1, getModel().getSurfer().getMultiplier());
            lastScoreIncrease = currentTime;
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        increaseScore(500);
        switch (action) {
            case LEFT:
                moveSurferLeft();
                break;
            case RIGHT:
                moveSurferRight();
                break;
        }
    }
}
