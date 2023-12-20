package org.crazytracks.model;

import org.crazytracks.model.track_element.Position;

public class TrackLoader extends TrackBuilder{
    @Override
    protected Surfer createSurfer() {
        return new Surfer(new Position(15,32));
    }
}
