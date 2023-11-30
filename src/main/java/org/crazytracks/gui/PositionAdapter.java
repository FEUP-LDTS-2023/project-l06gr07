package org.crazytracks.gui;

import org.crazytracks.model.Position;

public class PositionAdapter {
    private int offsetX;
    private int sizeOfTrack;
    public PositionAdapter(int offsetX, int sizeOfTrack){
        this.offsetX = offsetX;
        this.sizeOfTrack = sizeOfTrack;
    }

    public Position adaptPosition(Position position){
        return new Position(position.getX()+offsetX, sizeOfTrack - position.getY());
    }
}
