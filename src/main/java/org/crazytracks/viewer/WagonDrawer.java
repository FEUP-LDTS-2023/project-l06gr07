package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;
import org.crazytracks.model.Wagon;

public class WagonDrawer implements ElementViewer<Wagon> {

    @Override
    public void draw(Element element, GUI gui) {
        gui.drawWagon(element.getPosition());
    }
}
