package org.crazytracks.control;

import org.crazytracks.Game;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.*;
import org.crazytracks.model.track_element.coin.Coin;
import org.crazytracks.model.track_element.Position;
import org.crazytracks.model.track_element.PowerUp;
import org.crazytracks.model.track_element.Wagon;

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
            getModel().notifyPowerUpCollisionListeners();
        }
        else if (getModel().getTrackElement(position) instanceof Coin) {
            Coin coin = (Coin) getModel().getTrackElement(position);
            getModel().getSurfer().setPosition(position);
            getModel().getSurfer().collectCoin(coin);
            getModel().removeTrackElement(position);
            getModel().notifyCoinCollisionListeners();
        }
        else if (getModel().getTrackElement(position) instanceof Wagon){
            getModel().getSurfer().setAlive(false);
            getModel().notifyWagonCollisionListeners();
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
        double currSurferSpeed = getModel().getSurfer().getSurferSpeed();
        increaseScore((long) (1000/currSurferSpeed));
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
