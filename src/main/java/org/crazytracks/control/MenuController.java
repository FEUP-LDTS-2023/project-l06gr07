package org.crazytracks.control;

import org.crazytracks.Game;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.Menu;
import org.crazytracks.model.Track;
import org.crazytracks.model.TrackLoader;
import org.crazytracks.states.GameState;

import java.io.IOException;
public class MenuController extends Controller<Menu> {
    private Menu model;

    public MenuController(Menu model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) game.setState(new GameState(new TrackLoader().createTrack()));
        }
    }
}
