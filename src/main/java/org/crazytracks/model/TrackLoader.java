package org.crazytracks.model;

import org.crazytracks.gui.PositionAdapter;

public class TrackLoader extends TrackBuilder{
    @Override
    protected Surfer createSurfer() {
        return new Surfer(new Position(15,32));
    }
}
