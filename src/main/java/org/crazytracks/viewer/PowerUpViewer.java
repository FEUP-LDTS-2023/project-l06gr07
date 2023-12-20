package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;
import org.crazytracks.model.track_element.PowerUp;

public class PowerUpViewer implements ElementViewer<PowerUp> {

    @Override
    public void draw(Element element, GUI gui) {
        gui.drawPowerUp(element.getPosition());
    }
}
