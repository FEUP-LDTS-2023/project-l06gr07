package org.crazytracks.control;

import org.crazytracks.Game;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.*;
import org.crazytracks.model.factory.WagonFactory;

import java.io.IOException;
import java.util.List;

import static java.lang.Boolean.FALSE;

public class TrackElementController extends GameController{
    private long lastUpdateTime = System.currentTimeMillis();
    private long lastWagonCreationTime = System.currentTimeMillis();
    private long lastWagonCreationTime2 = System.currentTimeMillis();
    private WagonFactory wagonFactory;
    private WagonFactory wagonFactory2;
    public TrackElementController(Track model) {
        super(model);
        wagonFactory = new WagonFactory();
        wagonFactory2 = new WagonFactory();
    }

    public void moveWagons(long time) {
        long currentTime2 = System.currentTimeMillis();
        if (currentTime2 - lastUpdateTime >= time) {
            getModel().moveAllTrackElementsDown();
            checkWagonCollisions();
            lastUpdateTime = currentTime2;
        }
    }

    public void checkWagonCollisions(){
        List<Wagon> wagons = getModel().getWagons();
        for (Wagon wagon : wagons) {
            System.out.println("Wagon:" + wagon.getPosition().getX() + "," + wagon.getPosition().getY());
            System.out.println("Surfer:" + getModel().getSurfer().getPosition().getX() + "," + getModel().getSurfer().getPosition().getY());
            if (getModel().getSurfer().getPosition().equals(wagon.getPosition())) {
                getModel().getSurfer().setAlive(FALSE);
            }
            if (wagon.getPosition().getY() == 40){
                getModel().removeTrackElement(wagon.getPosition());
            }
        }
    }

    public void createWagon(long time){
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastWagonCreationTime >= time) {
            List<Element> wagons = wagonFactory.createElement();
            for (Element wagon : wagons) {
                if (getModel().isEmpty(wagon.getPosition())) {
                    getModel().addTrackElement((TrackElement) wagon);
                }
            }
            lastWagonCreationTime = currentTime;
        }
    }

    public void createWagon2(long time){
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastWagonCreationTime2 >= time) {
            List<Element> wagons = wagonFactory2.createElement();
            for (Element wagon : wagons) {
                if (getModel().isEmpty(wagon.getPosition())) {
                    getModel().addTrackElement((TrackElement) wagon);
                }
            }
            lastWagonCreationTime2 = currentTime;
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        createWagon(1300);
        createWagon2(1300);
        moveWagons(100);
    }
}
