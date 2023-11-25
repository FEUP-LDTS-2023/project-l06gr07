package org.crazytracks.model;

public class Wagon extends TrackElement {

    int wagon_lenght;

    public Wagon(Position position) {
        super(position);
    }

    protected CollisionStrategy createCollisionStrategy() {
        return new EndGameCollisionStrategy();
    }
}
