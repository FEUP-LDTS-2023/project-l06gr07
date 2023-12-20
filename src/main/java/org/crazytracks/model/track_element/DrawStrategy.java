package org.crazytracks.model.track_element;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;

public interface DrawStrategy {
    void draw(Element element, GUI gui);
}
