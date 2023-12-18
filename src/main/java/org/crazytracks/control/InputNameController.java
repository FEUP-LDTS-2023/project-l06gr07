package org.crazytracks.control;

import org.crazytracks.Game;
import org.crazytracks.gui.GUI;
import org.crazytracks.leaderboard.InputName;
import org.crazytracks.model.GameOver;
import org.crazytracks.states.GameOverState;

import java.io.IOException;

public class InputNameController extends Controller<InputName>{
    public InputNameController(InputName model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.SELECT){
            game.setState(new GameOverState(new GameOver(getModel().getSurfer().getScore(), (int) getModel().getSurfer().getSurferSpeed())));
        }
    }
}
