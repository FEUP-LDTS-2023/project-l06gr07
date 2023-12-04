package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.gui.LanternaGUI;
import org.crazytracks.model.Element;
import org.crazytracks.model.Track;

<<<<<<< HEAD
import java.io.IOException;
import java.util.List;

public class GameViewer extends Viewer<Track>{

    public GameViewer(Track model) {
        super(model);
=======
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class GameViewer implements Viewer {
    private List<Element> elements;
    private int numLanes;
    private int numTrackHeight;

    public GameViewer() throws IOException, URISyntaxException, FontFormatException {
        this.numLanes = 3; // width of the track in tiles
        this.numTrackHeight = 20; // height in tiles
>>>>>>> 3cb26f2aa4fae63373b032e8ee4b20dacd93d81d
    }


    private <T extends Element> void drawElements(GUI gui, List<Element> elements, ElementViewer<T> viewer) {
        for (Element element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, Element element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

    @Override
<<<<<<< HEAD
    protected void drawElements(GUI gui) throws IOException {
        gui.initGameGUI();
        drawElements(gui, getModel().getWagons(), new WagonViewer());
        drawElements(gui, getModel().getPowerUps(), new PowerUpViewer());
        drawElement(gui, getModel().getSurfer(), new SurferViewer());
        gui.putScore(getModel().getSurfer().getScore());
        gui.putMultiplier(getModel().getSurfer().getMultiplier());
=======
    public void draw(GUI gui) {
        GameState model = new GameState(new Track()); // get the model
        this.elements = new ArrayList<Element>(); // get the elements from model
        for (Element element : elements){
//            ElementDrawer drawer = element;
//            gui.drawElement(element.getView());
        }
>>>>>>> 3cb26f2aa4fae63373b032e8ee4b20dacd93d81d
    }
}
