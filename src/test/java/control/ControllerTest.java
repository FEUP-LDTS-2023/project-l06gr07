package control;

import org.crazytracks.Game;
import org.crazytracks.control.Controller;
import org.crazytracks.gui.GUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class ControllerTest {

    static class TestController extends Controller<String> {
        public TestController(String model) {
            super(model);
        }

        @Override
        public void step(Game game, GUI.ACTION action, long time) throws IOException {
            // Assert
            Assertions.assertNotNull(game);
            Assertions.assertNotNull(action);
            Assertions.assertTrue(time >= 0);
        }
    }

    @Test
    public void step() throws IOException {
        // Arrange
        String testModel = "Test Model";
        TestController testController = new TestController(testModel);

        TestController controllerSpy = Mockito.spy(testController);

        Game mockedGame = Mockito.mock(Game.class);
        GUI.ACTION mockedAction = GUI.ACTION.NONE;
        long mockedTime = 100L;

        // Act
        try {
            controllerSpy.step(mockedGame, mockedAction, mockedTime);
        } catch (IOException e) {
            Assertions.fail("IOException occurred during step execution: " + e.getMessage());
        }

        // Assert
        Mockito.verify(controllerSpy, Mockito.times(1)).step(mockedGame, mockedAction, mockedTime);
    }
}
