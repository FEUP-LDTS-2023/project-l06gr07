package org.crazytracks.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrackLoaderTest {
    @Test
    void testCreateTrack() {
        TrackLoader trackLoader = new TrackLoader();
        Track track = trackLoader.createTrack();
        Assertions.assertNotNull(track);

        Surfer surfer = track.getSurfer();
        Assertions.assertNotNull(surfer);

        Assertions.assertEquals(15, surfer.getPosition().getX());
        Assertions.assertEquals(32, surfer.getPosition().getY());
    }

}
