package org.crazytracks.states;

import org.crazytracks.control.Controller;
import org.crazytracks.control.GameOverController;
import org.crazytracks.control.TrackController;
import org.crazytracks.model.GameOver;
import org.crazytracks.viewer.GameOverViewer;
import org.crazytracks.viewer.Viewer;

public class GameOverState extends State<GameOver>{
    public GameOverState(GameOver model) {
        super(model);
    }

    @Override
    protected Viewer<GameOver> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOver> getController() {
        return new GameOverController((getModel()));
    }
}
