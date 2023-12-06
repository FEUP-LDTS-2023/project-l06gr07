package org.crazytracks.model;

public abstract class TrackBuilder {
    public Track createTrack() {
        Track arena = new Track();

        arena.setSurfer(createSurfer());

        return arena;
    }
    protected abstract Surfer createSurfer();
}
