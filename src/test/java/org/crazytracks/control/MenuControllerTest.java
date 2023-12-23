package org.crazytracks.control;

import org.crazytracks.Game;
import org.crazytracks.control.MenuController;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.Menu;
import org.crazytracks.states.GameState;
import org.crazytracks.states.LeaderboardState;
import org.crazytracks.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MenuControllerTest {
    private MenuController menuController;
    private Menu mockMenu;
    private Game mockGame;

    @BeforeEach
    void setUp() {
        mockMenu = Mockito.mock(Menu.class);
        mockGame = Mockito.mock(Game.class);
        menuController = new MenuController(mockMenu);
    }

    @Test
    void testStepUpAction() throws IOException {
        menuController.step(mockGame, GUI.ACTION.UP, 1000L);
        verify(mockMenu, times(1)).previousEntry();
    }

    @Test
    void testStepDownAction() throws IOException {
        menuController.step(mockGame, GUI.ACTION.DOWN, 1000L);
        verify(mockMenu, times(1)).nextEntry();
    }

    @Test
    void testStepSelectAction() throws IOException {
        Mockito.when(mockMenu.isSelectedStart()).thenReturn(true);
        menuController.step(mockGame, GUI.ACTION.SELECT, 1000L);
        verify(mockGame, times(1)).setState(Mockito.any(State.class));
    }

    @Test
    void testStepSelectAction2() throws IOException {
        Mockito.when(mockMenu.isSelectedLeaderboard()).thenReturn(true);
        menuController.step(mockGame, GUI.ACTION.SELECT, 1000L);
        verify(mockGame, times(1)).setState(Mockito.any(LeaderboardState.class));
    }
}