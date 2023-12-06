package org.crazytracks.control;

import org.crazytracks.Game;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.Position;
import org.crazytracks.model.Track;

import java.io.IOException;

public class SurferController extends GameController{
    public SurferController(Track model) {
        super(model);
    }

    public void moveSurfer(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getSurfer().setPosition(position);
            if (getModel().getSurfer().getPosition().equals(position)){
                //getModel().getTrackElement(position).getCollisionStrategy().handleCollision();
            }
        }

    }

    public void moveSurferLeft() {
        moveSurfer(getModel().getSurfer().getLeftPosition());
    }

    public void moveSurferRight() {
        moveSurfer(getModel().getSurfer().getRightPosition());
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
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
