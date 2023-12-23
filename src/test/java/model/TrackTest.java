package model;

import org.crazytracks.model.Track;
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

    @BeforeEach
    public void setUp(){
        this.track = new Track();
        List<TrackElement> trackElements = new ArrayList<>();
        trackElements.add(Mockito.mock(TrackElement.class));
        trackElements.add(Mockito.mock(TrackElement.class));
        trackElements.add(Mockito.mock(TrackElement.class));

        Mockito.when(trackElements.get(0).getPosition().getX()).thenReturn(0);
        Mockito.when(trackElements.get(0).getPosition().getY()).thenReturn(1);

        Mockito.when(trackElements.get(1).getPosition().getX()).thenReturn(2);
        Mockito.when(trackElements.get(1).getPosition().getY()).thenReturn(2);

        Mockito.when(trackElements.get(2).getPosition().getX()).thenReturn(1);
        Mockito.when(trackElements.get(2).getPosition().getY()).thenReturn(0);
        this.track.setTrackElements(trackElements);
    }

    @Test
    public void isEmpty(){
        Position pos = Mockito.mock(Position.class);

        Mockito.when(pos.getX()).thenReturn(0);
        Mockito.when(pos.getY()).thenReturn(0);
        Assertions.assertTrue(track.isEmpty(pos));

        Mockito.when(pos.getX()).thenReturn(0);
        Mockito.when(pos.getY()).thenReturn(1);
        Assertions.assertFalse(track.isEmpty(pos));
    }
}
