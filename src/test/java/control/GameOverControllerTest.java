package control;

import org.crazytracks.Game;
import org.crazytracks.control.GameOverController;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.GameOver;
import org.crazytracks.model.Surfer;
import org.crazytracks.model.Track;
import org.crazytracks.states.GameState;
import org.crazytracks.states.MenuState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOverControllerTest {

    @Test
    public void selectTryAgain() throws IOException {
        // Arrange
        GameOver gameOverModel = Mockito.mock(GameOver.class);
        GameOverController gameOverController = new GameOverController(gameOverModel);

        Game mockedGame = Mockito.mock(Game.class);
        GUI.ACTION mockedAction = GUI.ACTION.SELECT;
        long mockedTime = 100L;

        Surfer surfer = new Surfer(null);
        Track track = new Track();
        track.setSurfer(surfer);
        GameState gameState = new GameState(track);

        Mockito.when(mockedGame.getState()).thenReturn(gameState);
        Mockito.when(gameOverModel.getCurrentEntry()).thenReturn("Try Again");

        // Act
        gameOverController.step(mockedGame, mockedAction, mockedTime);

        // Assert
        Mockito.verify(mockedGame).setState(Mockito.any(GameState.class));
    }

    @Test
    public void selectBackToMenu() throws IOException {
        // Arrange
        GameOver gameOverModel = Mockito.mock(GameOver.class);
        GameOverController gameOverController = new GameOverController(gameOverModel);

        Game mockedGame = Mockito.mock(Game.class);
        GUI.ACTION mockedAction = GUI.ACTION.SELECT;
        long mockedTime = 100L;

        Surfer surfer = new Surfer(null);
        Track track = new Track();
        track.setSurfer(surfer);
        MenuState menuState = new MenuState(null);

        Mockito.when(mockedGame.getState()).thenReturn(menuState);
        Mockito.when(gameOverModel.getCurrentEntry()).thenReturn("Back to Menu");

        // Act
        gameOverController.step(mockedGame, mockedAction, mockedTime);

        // Assert
        Mockito.verify(mockedGame).setState(Mockito.any(MenuState.class));
    }
}
