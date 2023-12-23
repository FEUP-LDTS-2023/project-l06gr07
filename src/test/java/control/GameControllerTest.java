package control;

import org.crazytracks.Game;
import org.crazytracks.control.GameController;
import org.crazytracks.control.TrackController;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.Surfer;
import org.crazytracks.model.Track;
import org.crazytracks.states.InputNameState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.mock;

public class GameControllerTest {

    @Test
    public void step() throws IOException {
        // Arrange
        GameController gameController = mock(GameController.class);
        Game mockedGame = mock(Game.class);
        GUI.ACTION mockedAction = GUI.ACTION.NONE;
        long mockedTime = 100L;
        Mockito.doNothing().when(gameController).step(mockedGame, mockedAction, mockedTime);

        // Act
        try {
            gameController.step(mockedGame, mockedAction, mockedTime);
        } catch (IOException e) {
            Assertions.fail("IOException occurred during step execution: " + e.getMessage());
        }

        // Assert
        Mockito.verify(gameController).step(mockedGame, mockedAction, mockedTime);
    }

    @Test
    public void surferDeadTest() throws IOException {
        Game game = mock(Game.class);
        GUI.ACTION action = GUI.ACTION.NONE;
        Track track = mock(Track.class);
        Surfer surfer = mock(Surfer.class);
        Mockito.when(track.getSurfer()).thenReturn(surfer);
        Mockito.when(surfer.isAlive()).thenReturn(false);
        GameController gameController = new TrackController(track);
        gameController.step(game, action, 1000L);
        Mockito.verify(game).setState(Mockito.any(InputNameState.class));

    }
}

