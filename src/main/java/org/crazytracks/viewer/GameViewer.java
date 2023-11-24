package org.crazytracks.viewer;

import java.util.ArrayList;
import java.util.List;

public class GameViewer implements Viewer {
    List<ElementViewer> elements = new ArrayList<>();

    @Override
    public void updateGUI() {
        for (ElementViewer element : elements){
            element.draw();
        }
    }
}