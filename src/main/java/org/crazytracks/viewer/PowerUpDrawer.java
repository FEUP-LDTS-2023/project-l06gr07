package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;

public class PowerUpDrawer implements ElementDrawer {

    @Override
    public void draw(Element element, GUI gui) {
        gui.drawPowerUp(element.getPosition());
    }
}
