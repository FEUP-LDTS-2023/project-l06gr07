package org.crazytracks.control;

import org.crazytracks.Game;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.*;
import org.crazytracks.model.factory.WagonFactory;
import org.crazytracks.states.GameOverState;
import org.crazytracks.states.MenuState;

import java.io.IOException;
import java.util.List;

public class TrackController extends GameController {
    private SurferController surferController;
    private TrackElementController trackElementController;

    public TrackController(Track track) {
        super(track);
        this.surferController = new SurferController(track);
        this.trackElementController = new TrackElementController(track);
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT)
            game.setState(new MenuState(new Menu()));
        if (!getModel().getSurfer().isAlive()){
            game.setState(new GameOverState(new GameOver(getModel().getSurfer().getScore(), (int) getModel().getSurfer().getSurferSpeed())));
        }
        else {
            surferController.step(game, action, time);
            trackElementController.step(game, action, time);
        }
    }
}