package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.leaderboard.InputName;

import java.io.IOException;

public class InputNameViewer extends Viewer<InputName>{
    public InputNameViewer(InputName model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        gui.drawInputName(getModel().getInputText());
    }
}
