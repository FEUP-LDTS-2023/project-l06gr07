package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.GameOver;
import org.crazytracks.model.leaderboard.Player;
import org.crazytracks.viewer.GameOverViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;


public class GameOverViewerTest {
    private GameOver gameOver;
    private GameOverViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        Player player = new Player("Test", 10000, 25);
        gameOver = new GameOver(player);
        gui = org.mockito.Mockito.mock(GUI.class);
        viewer = new GameOverViewer(gameOver);
    }

    @Test
    void testDraw() throws Exception {
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawGameOver(Mockito.any(Player.class), Mockito.any(List.class), Mockito.eq(0));
    }
}