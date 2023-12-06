package org.crazytracks.control;

import org.crazytracks.Game;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.Track;

import java.io.IOException;

public class TrackElementController extends GameController{
    public TrackElementController(Track model) {
        super(model);
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

    }
}
