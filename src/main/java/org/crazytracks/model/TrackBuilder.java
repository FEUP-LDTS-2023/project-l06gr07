package org.crazytracks.model;

public abstract class TrackBuilder {
    public Track createTrack() {
        Track track = new Track();

        track.setSurfer(createSurfer());

        return track;
    }
    protected abstract Surfer createSurfer();
}
