package org.crazytracks.states;

import org.crazytracks.control.Controller;
import org.crazytracks.control.TrackController;
import org.crazytracks.model.Track;
import org.crazytracks.viewer.GameViewer;
import org.crazytracks.viewer.Viewer;

public class GameState extends State<Track>{
    public GameState(Track track) {
        super(track);
    }

    @Override
    protected Viewer<Track> getViewer() {
        return new GameViewer(getModel());
    }
    @Override
    protected Controller<Track> getController() {
        return new TrackController(getModel());
    }
}
