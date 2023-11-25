package org.crazytracks.model;

import java.util.List;

public class Track {
    private Surfer surfer;
    private List<TrackElement> trackElements;

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
}
