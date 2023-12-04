package org.crazytracks.model;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private Surfer surfer;
    private List<TrackElement> trackElements = new ArrayList<>();

    public Surfer getSurfer() {
        return surfer;
    }

    public void setSurfer(Surfer surfer) {
        this.surfer = surfer;
    }

    public List<TrackElement> getTrackElements() {
        return trackElements;
    }

    public void setTrackElements(List<TrackElement> trackElements) {
        this.trackElements = trackElements;
    }

    public List<Element> getWagons() {
        List<Element> wagons = new ArrayList<>();
        for (TrackElement trackElement : trackElements) {
            if (trackElement instanceof Wagon) {
                wagons.add((Wagon) trackElement);
            }
        }
        return wagons;
    }

    public List<Element> getPowerUps() {
        List<Element> powerUps = new ArrayList<>();
        for (TrackElement trackElement : trackElements) {
            if (trackElement instanceof PowerUp) {
                powerUps.add(trackElement);
            }
        }
        return powerUps;
    }

    public List<Element> getCoins() {
        List<Element> coins = new ArrayList<>();
        for (TrackElement trackElement : trackElements) {
            if (trackElement instanceof Coin) {
                coins.add(trackElement);
            }
        }
        return coins;
    }

    public void addTrackElement(TrackElement trackElement) {
        trackElements.add(trackElement);
    }
}
