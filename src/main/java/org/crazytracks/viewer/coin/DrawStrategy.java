package org.crazytracks.viewer.coin;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;

public interface DrawStrategy {
    void draw(Element element, GUI gui);
}
