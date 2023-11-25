package org.crazytracks.model;

public class PowerUp extends TrackElement{
    public CollisionStrategy createCollisionStrategy() {
        return new CSFCollisionStrategy();
    }
    public PowerUp(Position position) {
        super(position);
    }
}
