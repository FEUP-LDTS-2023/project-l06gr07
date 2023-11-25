package org.crazytracks.model;

import sun.util.resources.Bundles;

public class Coin extends TrackElement {
    protected CollisionStrategy createCollisionStrategy() {
        return new SICollisionStrategy();
    }
    public Coin(Position position) {
        super(position);
    }
}
