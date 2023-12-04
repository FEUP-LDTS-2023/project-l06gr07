package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;
import org.crazytracks.model.Track;

import java.io.IOException;
import java.util.List;

public class GameViewer extends Viewer<Track>{

    public GameViewer(Track model) {
        super(model);
    }


    private <T extends Element> void drawElements(GUI gui, List<Element> elements, ElementViewer<T> viewer) {
        for (Element element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, Element element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        gui.initGameGUI();
        drawElements(gui, getModel().getWagons(), new WagonDrawer());
        drawElements(gui, getModel().getPowerUps(), new PowerUpViewer());
        drawElement(gui, getModel().getSurfer(), new SurferViewer());
        gui.putScore(getModel().getSurfer().getScore());
        gui.putMultiplier(2);
    }
}
