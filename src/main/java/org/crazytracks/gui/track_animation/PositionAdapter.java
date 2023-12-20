package org.crazytracks.gui.track_animation;

import org.crazytracks.model.track_element.Position;

public class PositionAdapter {
    private final int offsetX;
    private final int sizeOfTrack;
    public PositionAdapter(int offsetX, int sizeOfTrack){
        this.offsetX = offsetX;
        this.sizeOfTrack = sizeOfTrack;
    }

    public Position adaptPosition(Position position){
        return new Position(position.getX()+offsetX, sizeOfTrack - position.getY());
    }
}
