package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;
import org.crazytracks.model.PowerUp;

public class PowerUpDrawer implements ElementDrawer<PowerUp> {

    @Override
    public void draw(Element element, GUI gui) {
        gui.drawPowerUp(element.getPosition());
    }
}
