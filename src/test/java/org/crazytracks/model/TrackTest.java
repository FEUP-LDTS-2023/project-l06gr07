package org.crazytracks.model;

import org.crazytracks.model.track_element.Position;
import org.crazytracks.model.track_element.TrackElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class TrackTest {
    private Track track;
    private List<TrackElement> trackElements;

    // some useful helper functions to avoid repeating code and save time
    public void trackElementsAddHelper(int x, int y){
        TrackElement trackElement = Mockito.mock(TrackElement.class);
        Position mockPosition = Mockito.mock(Position.class);
        Mockito.when(trackElement.getPosition()).thenReturn(mockPosition);
        Mockito.when(trackElement.getPosition().getX()).thenReturn(x);
        Mockito.when(trackElement.getPosition().getY()).thenReturn(y);
        this.trackElements.add(trackElement);
    }

    public Position posHelper(int x, int y){
        Position position = Mockito.mock(Position.class);
        Mockito.when(position.getX()).thenReturn(x);
        Mockito.when(position.getY()).thenReturn(y);
        return position;
    }

    public Surfer surferHelper(int x, int y){
        Surfer surfer = Mockito.mock(Surfer.class);
        Position position = posHelper(x, y);
        Mockito.when(surfer.getPosition()).thenReturn(position);
        return surfer;
    }

    @BeforeEach
    public void setUp(){
        this.track = new Track();
        Surfer trackSurfer = surferHelper(15, 32);
        this.track.setSurfer(trackSurfer);
        this.trackElements = new ArrayList<>();
        trackElementsAddHelper(0, 1);
        trackElementsAddHelper(2, 2);
        trackElementsAddHelper(1, 0);
        this.track.setTrackElements(trackElements);
    }

    @Test
    public void isEmpty(){
        Position pos;

        pos = posHelper(0, 0);
        Assertions.assertTrue(track.isEmpty(pos));
        pos = posHelper(4, 4);
        Assertions.assertTrue(track.isEmpty(pos));
        pos = posHelper(4, 5);
        Assertions.assertTrue(track.isEmpty(pos));
        pos = posHelper(14, 32);
        Assertions.assertTrue(track.isEmpty(pos));

        pos = posHelper(0, 1);
        Assertions.assertFalse(track.isEmpty(pos));
        pos = posHelper(2, 2);
        Assertions.assertFalse(track.isEmpty(pos));
        pos = posHelper(1, 0);
        Assertions.assertFalse(track.isEmpty(pos));
        pos = posHelper(15, 32);
        Assertions.assertFalse(track.isEmpty(pos));
    }
}
