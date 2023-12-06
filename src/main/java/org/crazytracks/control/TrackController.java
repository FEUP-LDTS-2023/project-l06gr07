package org.crazytracks.control;

import org.crazytracks.Game;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.Track;

import java.io.IOException;

public class TrackController extends GameController{
    private SurferController surferController;
    private TrackElementController trackElementController;

    public TrackController(Track track) {
        super(track);
        this.surferController = new SurferController(track);
        this.trackElementController = new TrackElementController(track);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

    }
}
