package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;

public class WagonDrawer implements ElementDrawer {

    @Override
    public void draw(Element element, GUI gui) {
        gui.drawWagon(element.getPosition());
    }
}
