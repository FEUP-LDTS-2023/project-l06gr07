package org.crazytracks.control;

import org.crazytracks.Game;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.leaderboard.InputName;
import org.crazytracks.model.leaderboard.Player;
import org.crazytracks.model.GameOver;
import org.crazytracks.model.Menu;
import org.crazytracks.states.GameOverState;
import org.crazytracks.states.MenuState;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class InputNameController extends Controller<InputName>{
    public InputNameController(InputName model) {
        super(model);
    }

    private void sendInvalidInputWarning(){
        getModel().setInputInvalid(true);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getModel().setInputInvalid(false);
            }
        }, 2000);
    }

    private void eraseLastChar(){
        String inputText = getModel().getInputText();
        if (!inputText.isEmpty()){
            getModel().setInputText(inputText.substring(0, inputText.length()-1));
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.TYPING){
            char currChar = getModel().getGUI().getCurrChar();
            getModel().setInputText(getModel().getInputText() + currChar);
        }
        if (action == GUI.ACTION.UNDO){
            eraseLastChar();
        }
        if (action == GUI.ACTION.SELECT){
            if (getModel().getInputText().matches(".*[a-zA-Z0-9].*")) {
                Player player = new Player(
                        getModel().getInputText(),
                        getModel().getSurfer().getScore(),
                        (int) getModel().getSurfer().getSurferSpeed()
                );
                game.getLeaderboard().insertPlayer(player);
                game.setState(new GameOverState(new GameOver(player)));
            } else {
                sendInvalidInputWarning();
            }
        }
        if (action == GUI.ACTION.QUIT){
            game.setState(new MenuState(new Menu()));
        }
    }
}
