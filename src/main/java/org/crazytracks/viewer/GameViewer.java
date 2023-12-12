package org.crazytracks.viewer;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;
import org.crazytracks.model.Track;

import javax.swing.*;
import java.util.List;

public class GameViewer extends Viewer<Track>{

    public GameViewer(Track model) {
        super(model);
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, Element element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

    protected void drawElements(GUI gui){
        gui.initGameGUI(getModel().getAnimMode());
        drawElements(gui, getModel().getPowerUps(), new PowerUpViewer());
        drawElements(gui, getModel().getCoins(), new CoinViewer());
        drawElement(gui, getModel().getSurfer(), new SurferViewer());
        drawElements(gui, getModel().getWagons(), new WagonViewer());
        gui.putScore(getModel().getSurfer().getScore());
        gui.putMultiplier(getModel().getSurfer().getMultiplier());

    }
}
