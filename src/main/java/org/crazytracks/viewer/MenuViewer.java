package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.gui.TrackAnimation;
import org.crazytracks.model.Menu;

import java.io.IOException;

public class MenuViewer extends Viewer<Menu>{
    public MenuViewer(Menu model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        gui.drawMenu(getModel().getEntries(), getModel().getCurrentEntryIndex());
    }
}
