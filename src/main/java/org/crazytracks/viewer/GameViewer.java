package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;
import org.crazytracks.model.GameState;
import org.crazytracks.model.State;
import org.crazytracks.model.Track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameViewer implements Viewer {
    private List<Element> elements;
    private int numLanes;
    private int numTrackHeight;
    private GUI gui;
    public GameViewer(GUI gui){
        this.numLanes = 3; // width of the track in tiles
        this.numTrackHeight = 20; // height in tiles
        this.gui = gui;
        gui.initGameGUI();
    }
    @Override
    public void updateGUI() {
        GameState model = new GameState(new Track()); // get the model
        this.elements = new ArrayList<Element>(); // get the elements from model
        for (Element element : elements){
//            ElementDrawer drawer = element;
            gui.drawElement(element.getView());
        }
    }


}