package control;

import org.crazytracks.Game;
import org.crazytracks.control.GameController;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.Track;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameControllerTest {

    @Test
    public void step() throws IOException {
        GameController gameController = new GameController(new Track()) {
            @Override
            public void step(Game game, GUI.ACTION action, long time) throws IOException {
                // not implemented
            }
        };
        Game mockedGame = Mockito.mock(Game.class);
        GUI.ACTION mockedAction = GUI.ACTION.NONE;
        long mockedTime = 100L;

        gameController.step(mockedGame, mockedAction, mockedTime);

        Assertions.assertNotNull(gameController.getModel());
    }
}

