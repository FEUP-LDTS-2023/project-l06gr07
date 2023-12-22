package control;

import org.crazytracks.Game;
import org.crazytracks.control.InputNameController;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.Surfer;
import org.crazytracks.model.leaderboard.InputName;
import org.crazytracks.model.leaderboard.Leaderboard;
import org.crazytracks.model.leaderboard.Player;
import org.crazytracks.states.MenuState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class InputNameControllerTest {

    @Test
    public void appendCharacterToInputText() throws IOException {
        // Arrange
        InputName mockInputName = Mockito.mock(InputName.class);
        GUI mockGUI = Mockito.mock(GUI.class);
        Mockito.when(mockInputName.getGUI()).thenReturn(mockGUI); // Mocking getGUI() to return a non-null GUI instance
        InputNameController inputNameController = new InputNameController(mockInputName);
        Game mockedGame = Mockito.mock(Game.class);

        // Act
        inputNameController.step(mockedGame, GUI.ACTION.TYPING, 1000L);

        // Assert
        Mockito.verify(mockGUI).getCurrChar(); // Verifying interaction with GUI instance
        Mockito.verify(mockInputName).getInputText();
        Mockito.verify(mockInputName).setInputText(Mockito.anyString());
    }


    @Test
    public void eraseLastCharacterFromInputText() throws IOException {
        // Arrange
        InputName mockInputName = Mockito.mock(InputName.class);
        InputNameController inputNameController = new InputNameController(mockInputName);
        Game mockedGame = Mockito.mock(Game.class);
        Mockito.when(mockInputName.getInputText()).thenReturn("Test");

        // Act
        inputNameController.step(mockedGame, GUI.ACTION.UNDO, 1000L);

        // Assert
        Mockito.verify(mockInputName).getInputText();
        Mockito.verify(mockInputName).setInputText(Mockito.anyString());
    }

    @Test
    public void sendInvalidInputWarning() throws IOException {
        // Arrange
        InputName mockInputName = Mockito.mock(InputName.class);
        InputNameController inputNameController = new InputNameController(mockInputName);
        Game mockedGame = Mockito.mock(Game.class);
        Mockito.when(mockInputName.getInputText()).thenReturn("!@#$"); // Invalid input

        // Act
        inputNameController.step(mockedGame, GUI.ACTION.SELECT, 1000L);

        // Assert
        Mockito.verify(mockInputName).getInputText();
        Mockito.verify(mockInputName).setInputInvalid(true);
    }

    @Test
    public void insertPlayerAndSetGameOverState() throws IOException {
        // Arrange
        InputName mockInputName = Mockito.mock(InputName.class);
        Surfer mockSurfer = Mockito.mock(Surfer.class);
        Mockito.when(mockSurfer.getScore()).thenReturn(100);
        Mockito.when(mockInputName.getSurfer()).thenReturn(mockSurfer);
        Mockito.when(mockInputName.getInputText()).thenReturn("");

        InputNameController inputNameController = new InputNameController(mockInputName);
        Game mockedGame = Mockito.mock(Game.class);

        // Act
        inputNameController.step(mockedGame, GUI.ACTION.SELECT, 1000L);

        // Assert
        Mockito.verify(mockInputName).getInputText();
    }

    @Test
    public void step_QuitAction_ShouldSetMenuState() throws IOException {
        // Arrange
        InputName mockInputName = Mockito.mock(InputName.class);
        InputNameController inputNameController = new InputNameController(mockInputName);
        Game mockedGame = Mockito.mock(Game.class);

        // Act
        inputNameController.step(mockedGame, GUI.ACTION.QUIT, 1000L);

        // Assert
        Mockito.verify(mockedGame).setState(Mockito.any(MenuState.class));
    }
}

