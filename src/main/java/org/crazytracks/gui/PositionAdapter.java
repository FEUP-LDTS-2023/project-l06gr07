package org.crazytracks.gui;

import org.crazytracks.model.Position;

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
