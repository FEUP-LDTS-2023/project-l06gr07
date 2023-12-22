package org.crazytracks.control;

import org.crazytracks.model.Track;

public abstract class GameController extends Controller<Track> {
    public GameController(Track model) {
        super(model);
    }
}
