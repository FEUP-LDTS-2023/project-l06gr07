package control;

import org.crazytracks.Game;
import org.crazytracks.control.GameController;
import org.crazytracks.gui.GUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameControllerTest {

    @Test
    public void step() throws IOException {
        // Arrange
        GameController gameController = Mockito.mock(GameController.class);
        Game mockedGame = Mockito.mock(Game.class);
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
}

