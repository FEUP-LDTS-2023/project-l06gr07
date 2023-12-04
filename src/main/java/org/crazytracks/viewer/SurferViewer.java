package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;
import org.crazytracks.model.Surfer;

public class SurferDrawer implements ElementDrawer<Surfer> {
    @Override
    public void draw(Element surfer, GUI gui) {
        gui.drawSurfer(surfer.getPosition());
    }
}
