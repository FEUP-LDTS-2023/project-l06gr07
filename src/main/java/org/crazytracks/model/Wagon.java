package org.crazytracks.model;

public class Wagon extends TrackElement {
    protected CollisionStrategy createCollisionStrategy() {
        return new EndGameCollisionStrategy();
    }
    public Wagon(Position position) {
        super(position);
    }
}
