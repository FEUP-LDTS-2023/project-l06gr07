package org.crazytracks.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TrackBuilderTest {
    @Test
    void testCreateTrack() {
        TrackBuilder trackBuilder = new TrackBuilder() {
            @Override
            protected Surfer createSurfer() {
                return Mockito.mock(Surfer.class);
            }
        };

        Track track = trackBuilder.createTrack();

        Assertions.assertNotNull(track);

        Surfer surfer = track.getSurfer();
        Assertions.assertNotNull(surfer);
    }
}
