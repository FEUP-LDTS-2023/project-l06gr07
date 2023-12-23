package org.crazytracks.control;

import org.crazytracks.Game;
import org.crazytracks.control.LeaderboardController;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.leaderboard.Leaderboard;
import org.crazytracks.states.MenuState;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.times;

public class LeaderboardControllerTest {

    @Test
    public void selectAction() throws IOException {
        // Arrange
        Leaderboard mockLeaderboard = Mockito.mock(Leaderboard.class);
        Mockito.when(mockLeaderboard.getCurrentEntry()).thenReturn("Back to Menu");
        Game mockedGame = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.SELECT;
        LeaderboardController leaderboardController = new LeaderboardController(mockLeaderboard);

        // Act
        leaderboardController.step(mockedGame, action, 1000L);

        // Assert
        Mockito.verify(mockedGame, times(1)).setState(ArgumentMatchers.any(MenuState.class));
    }

    @Test
    public void upAction() throws IOException {
        // Arrange
        Leaderboard mockLeaderboard = Mockito.mock(Leaderboard.class);
        LeaderboardController leaderboardController = new LeaderboardController(mockLeaderboard);
        Game mockedGame = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.UP;

        // Act
        leaderboardController.step(mockedGame, action, 1000L);

        // Assert
        Mockito.verify(mockLeaderboard, times(1)).previousEntry();
    }

    @Test
    public void downAction() throws IOException {
        // Arrange
        Leaderboard mockLeaderboard = Mockito.mock(Leaderboard.class);
        Game mockedGame = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.DOWN;
        LeaderboardController leaderboardController = new LeaderboardController(mockLeaderboard);

        // Act
        leaderboardController.step(mockedGame, action, 1000L);

        // Assert
        Mockito.verify(mockLeaderboard, times(1)).nextEntry();
    }
}
