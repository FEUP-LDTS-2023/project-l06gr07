package org.crazytracks.control;

import org.crazytracks.Game;
import org.crazytracks.control.TrackElementController;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.Surfer;
import org.crazytracks.model.Track;
import org.crazytracks.model.track_element.Position;
import org.crazytracks.model.track_element.PowerUp;
import org.crazytracks.model.track_element.Wagon;
import org.crazytracks.model.track_element.coin.Coin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TrackElementControllerTest {
    private TrackElementController trackElementController;
    private Track mockTrack;
    private Game mockGame;
    private Surfer mockSurfer;

    @BeforeEach
    void setUp() {
        mockGame = Mockito.mock(Game.class);
        mockTrack = Mockito.mock(Track.class);
        mockSurfer = Mockito.mock(Surfer.class);
        Mockito.when(mockTrack.getSurfer()).thenReturn(mockSurfer);
        Mockito.when(mockSurfer.getSurferSpeed()).thenReturn(10);
        trackElementController = new TrackElementController(mockTrack);
    }

    @Test
    void testPowerUpCollision() throws IOException {
        PowerUp mockPowerUp = Mockito.mock(PowerUp.class);
        Mockito.when(mockPowerUp.getPosition()).thenReturn(new Position(15, 0));
        Mockito.when(mockTrack.getTrackElement(new Position(15, 0))).thenReturn(mockPowerUp);
        trackElementController.step(mockGame, GUI.ACTION.NONE, 1000L);
        verify(mockSurfer, times(1)).setMultiplier(Mockito.anyInt());
    }
}