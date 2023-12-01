package org.crazytracks.gui;

import org.crazytracks.control.Controller;
import org.crazytracks.model.Element;
import org.crazytracks.model.Position;
import org.crazytracks.model.TrackElement;
import org.crazytracks.model.Wagon;
import org.crazytracks.viewer.ElementDrawer;
import org.crazytracks.viewer.WagonDrawer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TrackAnimation {
    private final int trackHeight;
    private int numLanes;
    private GUI gui;
    public enum teType {
        WAGON,
        COIN,
        POWER_UP,
        NOTHING
    }
    private List<List<teType>> fakeTrack;
    private List<TrackElement> fakeElements;
    public TrackAnimation(GUI gui, int numLanes, int trackHeight) {
        this.numLanes = numLanes;
        this.trackHeight = trackHeight;
        this.gui = gui;
        initFakeTrack();
//        initAnimation();
    }

    public teType randomTEType(){
        Random random = new Random();
        teType[] types = teType.values();
        int randomIndex = random.nextInt(types.length);
        return types[randomIndex];
    }
    public void step(){

    }
    private void initFakeTrack(){
        this.fakeTrack = new ArrayList<>();
        for (List<teType> section : this.fakeTrack){
            section = new ArrayList<>();
            for (teType tile : section){
                section.add(randomTEType());
            }
        }
    }

    private void initAnimation(List<TrackElement> initialElements){

    }

}
