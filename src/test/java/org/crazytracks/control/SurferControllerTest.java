package org.crazytracks.control;

import org.crazytracks.Game;
import org.crazytracks.control.SurferController;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.Animation;
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

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SurferControllerTest {
    private SurferController surferController;
    private Surfer mockSurfer;
    private Game mockGame;
    private Track track;

    @BeforeEach
    void setUp() {
        mockGame = Mockito.mock(Game.class);

        mockSurfer = Mockito.mock(Surfer.class);
        track = new Track();
        track.setSurfer(mockSurfer);
        Animation animation = Mockito.mock(Animation.class);
        Mockito.when(mockSurfer.getAnim()).thenReturn(animation);
        Mockito.when(mockSurfer.getPosition()).thenReturn(new Position(15, 0));
        Mockito.when(mockSurfer.getCurrentLane()).thenReturn(1);
        surferController = new SurferController(track);
    }

    @Test
    void testStepLeftAction() throws IOException {
        Mockito.when(mockSurfer.getLeftPosition()).thenReturn(new Position(14, 0));
        surferController.step(mockGame, GUI.ACTION.LEFT, 1000L);
        verify(mockSurfer, times(1)).setPosition(Mockito.any(Position.class));
    }

    @Test
    void testStepRightAction() throws IOException {
        Mockito.when(mockSurfer.getRightPosition()).thenReturn(new Position(16, 0));
        surferController.step(mockGame, GUI.ACTION.RIGHT, 1000L);
        verify(mockSurfer, times(1)).setPosition(Mockito.any(Position.class));
    }

    @Test
    void testCollisionWithPowerUp() throws IOException {
        Position powerUpPosition = new Position(15, 0);
        PowerUp mockPowerUp = Mockito.mock(PowerUp.class);
        Mockito.when(mockPowerUp.getPosition()).thenReturn(powerUpPosition);
        track.addTrackElement(mockPowerUp);
        Mockito.when(mockSurfer.getMultiplier()).thenReturn(1);

        // Simulate the behavior of the step method when a collision with a PowerUp occurs
        Mockito.when(mockSurfer.getPosition()).thenReturn(new Position(16,0));
        Mockito.when(mockSurfer.getLeftPosition()).thenReturn(new Position(15,0));

        surferController.step(mockGame, GUI.ACTION.LEFT, 1000L);

        verify(mockSurfer, times(1)).setMultiplier(Mockito.anyInt());
    }

    @Test
    void testCollisionWithCoin() throws IOException {
        Position coinPosition = new Position(15, 0);
        Coin mockCoin = Mockito.mock(Coin.class);
        Mockito.when(mockCoin.getPosition()).thenReturn(coinPosition);
        track.addTrackElement(mockCoin);

        Mockito.when(mockSurfer.getPosition()).thenReturn(new Position(16,0));
        Mockito.when(mockSurfer.getLeftPosition()).thenReturn(new Position(15,0));

        surferController.step(mockGame, GUI.ACTION.LEFT, 1000L);

        verify(mockSurfer, times(1)).collectCoin(mockCoin);
    }

    @Test
    void testCollisionWithWagon() throws IOException {
        Position wagonPosition = new Position(15, 0);
        Wagon mockWagon = Mockito.mock(Wagon.class);
        Mockito.when(mockWagon.getPosition()).thenReturn(wagonPosition);
        track.addTrackElement(mockWagon);

        Mockito.when(mockSurfer.getPosition()).thenReturn(new Position(16,0));
        Mockito.when(mockSurfer.getLeftPosition()).thenReturn(new Position(15,0));

        surferController.step(mockGame, GUI.ACTION.LEFT, 1000L);

        verify(mockSurfer, times(1)).setAlive(false);
    }

}