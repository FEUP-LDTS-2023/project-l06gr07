package org.crazytracks.model;

public abstract class TrackElement extends Element {
    private CollisionStrategy collisionStrategy;

    public CollisionStrategy getCollisionStrategy() {
        return collisionStrategy;
    }
    public TrackElement(Position position) {
        super(position);
    }
}
