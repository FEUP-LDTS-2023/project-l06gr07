package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;
import org.crazytracks.model.GameOver;

import java.io.IOException;

public class GameOverViewer extends Viewer<GameOver> {
    public GameOverViewer(GameOver model){
        super(model);
    }
    @Override
    protected void drawElements(GUI gui) throws IOException {
        gui.drawGameOver(getModel().getScore(), getModel().getOptions(), getModel().getSelected());
    }
}
