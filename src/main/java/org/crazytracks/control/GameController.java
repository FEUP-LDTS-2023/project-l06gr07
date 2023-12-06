package org.crazytracks.control;

import org.crazytracks.Game;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.Track;

import java.io.IOException;

public abstract class GameController extends Controller<Track> {
    public GameController(Track model) {
        super(model);
    }
}
