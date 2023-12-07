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

    public boolean isEmpty(Position position) {
        for (TrackElement trackElement : trackElements) {
            if (trackElement.getPosition().equals(position)) {
                return false;
            }
        }
        return !surfer.getPosition().equals(position);
    }

    public TrackElement getTrackElement(Position position) {
        for (TrackElement trackElement : trackElements) {
            if (trackElement.getPosition().equals(position)) {
                return trackElement;
            }
        }
        return null;
    }

    public List<Wagon> getWagons() {
        List<Wagon> wagons = new ArrayList<>();
        for (TrackElement trackElement : trackElements) {
            if (trackElement instanceof Wagon) {
                wagons.add((Wagon) trackElement);
            }
        }
        return wagons;
    }

    public List<PowerUp> getPowerUps() {
        List<PowerUp> powerUps = new ArrayList<>();
        for (TrackElement trackElement : trackElements) {
            if (trackElement instanceof PowerUp) {
                powerUps.add((PowerUp) trackElement);
            }
        }
        return powerUps;
    }

    public List<Coin> getCoins() {
        List<Coin> coins = new ArrayList<>();
        for (TrackElement trackElement : trackElements) {
            if (trackElement instanceof Coin) {
                coins.add((Coin) trackElement);
            }
        }
        return coins;
    }

    public void addTrackElement(TrackElement trackElement) {
        trackElements.add(trackElement);
    }

    public void removeTrackElement(Position position) {
        TrackElement trackElement = getTrackElement(position);
        trackElements.remove(trackElement);
    }

    public void moveAllTrackElementsDown() {
        for (TrackElement trackElement : trackElements) {
            trackElement.setPosition(trackElement.getDownPosition());
        }
    }
}
