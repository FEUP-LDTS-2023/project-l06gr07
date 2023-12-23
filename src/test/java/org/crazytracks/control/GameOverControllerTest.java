package org.crazytracks.control;

import org.crazytracks.Game;
import org.crazytracks.control.GameOverController;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.GameOver;
import org.crazytracks.model.Surfer;
import org.crazytracks.model.Track;
import org.crazytracks.model.leaderboard.Player;
import org.crazytracks.states.GameState;
import org.crazytracks.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GameOverControllerTest {

    private GameOver mockGameOver;
    private GameOverController gameOverController;
    private Game mockGame;


    @BeforeEach
    void setUp() {
        mockGameOver = Mockito.mock(GameOver.class);
        gameOverController = new GameOverController(mockGameOver);
        mockGame = Mockito.mock(Game.class);
    }
    @Test
    public void testStepUpAction() throws IOException {
        Mockito.when(mockGameOver.getCurrentEntry()).thenReturn("Try Again");

        gameOverController.step(mockGame, GUI.ACTION.UP, 1000L);

        Mockito.verify(mockGameOver).previousEntry();
    }

    @Test
    public void testStepDownAction() throws IOException {
        gameOverController.step(mockGame, GUI.ACTION.DOWN, 1000L);

        Mockito.verify(mockGameOver).nextEntry();
    }

    @Test
    public void testStepSelectAction() throws IOException {
        Mockito.when(mockGameOver.getCurrentEntry()).thenReturn("Try Again");

        gameOverController.step(mockGame, GUI.ACTION.SELECT, 1000L);

        Mockito.verify(mockGame).setState(Mockito.any(GameState.class));
    }

    @Test
    public void testStepSelectAction2() throws IOException {

        Mockito.when(mockGameOver.getCurrentEntry()).thenReturn("Back to Menu");

        gameOverController.step(mockGame, GUI.ACTION.SELECT, 1000L);

        Mockito.verify(mockGame,Mockito.times(1)).setState(Mockito.any(MenuState.class));
    }

    @Test
    public void testNextEntry() {
        GameOver gameOver = new GameOver(new Player("Test", 0,0));
        String firstEntry = gameOver.getCurrentEntry();

        gameOver.nextEntry();
        String secondEntry = gameOver.getCurrentEntry();

        assertNotEquals(firstEntry, secondEntry, "The current entry should change after calling nextEntry");
    }

    @Test
    public void testPreviousEntry() {
        GameOver gameOver = new GameOver(new Player("Test", 0,0));
        String firstEntry = gameOver.getCurrentEntry();

        gameOver.previousEntry();
        String secondEntry = gameOver.getCurrentEntry();

        assertNotEquals(firstEntry, secondEntry, "The current entry should change after calling previousEntry");
    }
}
