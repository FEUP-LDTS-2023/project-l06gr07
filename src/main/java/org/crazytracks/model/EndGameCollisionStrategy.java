package org.crazytracks.model;

import org.crazytracks.Game;
import org.crazytracks.states.MenuState;

public class EndGameCollisionStrategy extends CollisionStrategy {

        public void handleCollision(Game game) {
            game.setState(new MenuState(new Menu()));
        }
}
