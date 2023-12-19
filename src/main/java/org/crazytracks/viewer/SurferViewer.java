package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;
import org.crazytracks.model.Surfer;

public class SurferViewer implements ElementViewer<Surfer> {
    @Override
    public void draw(Element surfer, GUI gui) {
        gui.drawSurfer((Surfer) surfer);
    }
}
