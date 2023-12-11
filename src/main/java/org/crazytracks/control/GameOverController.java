package org.crazytracks.control;

import org.crazytracks.Game;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.GameOver;
import org.crazytracks.model.Menu;
import org.crazytracks.model.TrackLoader;
import org.crazytracks.states.GameState;
import org.crazytracks.states.MenuState;

import java.io.IOException;

public class GameOverController extends Controller<GameOver> {
    private GameOver model;
    public GameOverController(GameOver model){
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case QUIT:
            case SELECT:
                game.setState(new MenuState(new Menu()));
                break;
            case NONE:
                break;
        }
    }
}
