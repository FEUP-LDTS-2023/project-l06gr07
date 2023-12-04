package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.gui.LanternaGUI;
import org.crazytracks.model.Element;
import org.crazytracks.model.GameState;
import org.crazytracks.model.Track;

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
    }
    @Override
    public void draw(GUI gui) {
        GameState model = new GameState(new Track()); // get the model
        this.elements = new ArrayList<Element>(); // get the elements from model
        for (Element element : elements){
//            ElementDrawer drawer = element;
//            gui.drawElement(element.getView());
        }
    }


}