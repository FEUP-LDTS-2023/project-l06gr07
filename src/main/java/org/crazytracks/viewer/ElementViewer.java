package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;
import org.crazytracks.model.TrackElement;

public interface ElementDrawer<T extends Element> {
    public void draw(Element element, GUI gui);
}
