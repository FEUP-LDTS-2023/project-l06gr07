package org.crazytracks.model;

import org.crazytracks.Game;
import org.crazytracks.states.MenuState;

public abstract class CollisionStrategy {

    public abstract void handleCollision(Game game);

}
