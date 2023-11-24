package org.crazytracks.model;

public class PowerUp extends TrackElement{
    protected CollisionStrategy createCollisionStrategy() {
        return new CSFCollisionStrategy();
    }
    public PowerUp(Position position) {
        super(position);
    }
}
