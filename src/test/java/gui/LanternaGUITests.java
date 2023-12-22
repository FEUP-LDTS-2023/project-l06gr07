package gui;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.crazytracks.gui.LanternaGUI;
import org.crazytracks.model.leaderboard.Player;
import org.crazytracks.model.track_element.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class LanternaGUITests {
    private LanternaGUI lanternaGUI;
    private Screen mockScreen;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        mockScreen = Mockito.mock(Screen.class);
        lanternaGUI = new LanternaGUI(30,40);
        lanternaGUI.setScreen(mockScreen);
    }

    @Test
    void testDrawCopperCoin() throws IOException {
        lanternaGUI.drawCopperCoin(new Position(1, 1));
        verify(mockScreen, times(1)).setCharacter(Mockito.anyInt(),Mockito.anyInt(), Mockito.any());
    }

    @Test
    void testDrawGoldCoin() throws IOException {
        lanternaGUI.drawGoldCoin(new Position(1, 1));
        verify(mockScreen, times(1)).setCharacter(Mockito.anyInt(),Mockito.anyInt(), Mockito.any());
    }

    @Test
    void testDrawSurfer() throws IOException {
        lanternaGUI.drawSurfer(new Position(1, 1), 0);
        verify(mockScreen, times(1)).setCharacter(Mockito.anyInt(),Mockito.anyInt(), Mockito.any());
    }

@Test
    void testDrawPowerUp() throws IOException {
        lanternaGUI.drawPowerUp(new Position(1, 1));
        verify(mockScreen, times(1)).setCharacter(Mockito.anyInt(),Mockito.anyInt(), Mockito.any());
    }

    @Test
    void testDrawWagon() throws IOException {
        lanternaGUI.drawWagon(new Position(1, 1));
        verify(mockScreen, times(1)).setCharacter(Mockito.anyInt(),Mockito.anyInt(), Mockito.any());
    }

    @Test
    void testClearScreen() throws IOException {
        lanternaGUI.clearScreen();

        verify(mockScreen, times(1)).clear();
    }

    @Test
    void testGetNextAction() throws IOException {
        KeyStroke mockKeyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(mockScreen.pollInput()).thenReturn(mockKeyStroke);
        Mockito.when(mockKeyStroke.getKeyType()).thenReturn(KeyType.ArrowUp);

        LanternaGUI.ACTION action = lanternaGUI.getNextAction();

        verify(mockScreen, times(1)).pollInput();
        assertEquals(LanternaGUI.ACTION.UP, action);
    }

    @Test
    void testCloseScreen() throws IOException {
        lanternaGUI.closeScreen();

        verify(mockScreen, times(1)).close();
    }
}