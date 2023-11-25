package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;

public class SurferDrawer implements ElementDrawer {
    @Override
    public void draw(Element surfer, GUI gui) {
        gui.drawSurfer(surfer.getPosition());
    }
}
