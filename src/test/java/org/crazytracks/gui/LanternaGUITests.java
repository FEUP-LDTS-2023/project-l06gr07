package org.crazytracks.gui;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.crazytracks.gui.LanternaGUI;
import org.crazytracks.gui.track_animation.TrackAnimation;
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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class LanternaGUITests {
    private LanternaGUI lanternaGUI;
    private Screen screen;
    private TextGraphics tg;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(tg);
        Mockito.when(tg.setBackgroundColor(Mockito.any())).thenReturn(tg);
        Mockito.when(tg.setForegroundColor(Mockito.any())).thenReturn(tg);
        lanternaGUI = new LanternaGUI(screen);
    }

    @Test
    void testDrawCopperCoin() {
        Position position = Mockito.mock(Position.class);
        TextCharacter expectedCharacter = new TextCharacter('$')
                .withForegroundColor(TextColor.ANSI.YELLOW)
                .withBackgroundColor(TextColor.ANSI.WHITE);

        lanternaGUI.drawCopperCoin(position);

        verify(screen, times(1)).setCharacter(Mockito.anyInt(), Mockito.anyInt(), Mockito.eq(expectedCharacter));
    }

    @Test
    void testDrawGoldCoin() {
        Position position = Mockito.mock(Position.class);
        TextCharacter expectedCharacter = new TextCharacter('$')
                .withForegroundColor(TextColor.ANSI.YELLOW_BRIGHT)
                .withBackgroundColor(TextColor.ANSI.WHITE);

        lanternaGUI.drawGoldCoin(position);

        verify(screen, times(1)).setCharacter(Mockito.anyInt(), Mockito.anyInt(), Mockito.eq(expectedCharacter));
    }

    @Test
    void testDrawPowerUp() {
        Position position = Mockito.mock(Position.class);
        TextCharacter expectedCharacter = new TextCharacter('P')
                .withForegroundColor(TextColor.ANSI.GREEN_BRIGHT)
                .withBackgroundColor(TextColor.ANSI.WHITE);

        lanternaGUI.drawPowerUp(position);

        verify(screen, times(1)).setCharacter(Mockito.anyInt(), Mockito.anyInt(), Mockito.eq(expectedCharacter));
    }

    @Test
    void testDrawWagon() {
        Position position = Mockito.mock(Position.class);
        TextCharacter expectedCharacter = new TextCharacter('|')
                .withForegroundColor(TextColor.ANSI.BLACK)
                .withBackgroundColor(TextColor.ANSI.RED);

        lanternaGUI.drawWagon(position);

        verify(screen, times(1)).setCharacter(Mockito.anyInt(), Mockito.anyInt(), Mockito.eq(expectedCharacter));
    }

    @Test
    void testDrawSurfer() {
        Position position = Mockito.mock(Position.class);
        TextCharacter expectedCharacter = new TextCharacter('«')
                .withForegroundColor(TextColor.ANSI.BLUE)
                .withBackgroundColor(new TextColor.RGB(188,187,156));

        lanternaGUI.drawSurfer(position, 0);

        verify(screen, times(1)).setCharacter(Mockito.anyInt(), Mockito.anyInt(), Mockito.eq(expectedCharacter));
    }

    @Test
    void testPutCharacter() {
        Position position = Mockito.mock(Position.class);
        TextCharacter expectedCharacter = new TextCharacter('P')
                .withForegroundColor(TextColor.ANSI.GREEN_BRIGHT)
                .withBackgroundColor(TextColor.ANSI.WHITE);

        lanternaGUI.putCharacter(position, expectedCharacter);

        verify(screen, times(1)).setCharacter(Mockito.anyInt(), Mockito.anyInt(), Mockito.eq(expectedCharacter));
    }

    @Test
    void testPutScore() {
        int score = 100;
        int xMargin = 2;
        int yMargin = 2;

        lanternaGUI.putScore(score, xMargin, yMargin);

        verify(tg, times(2)).putString(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    void testPutMultiplier() {
        int powerUpValue = 2;
        boolean multiplierOn = true;

        lanternaGUI.putMultiplier(powerUpValue, multiplierOn);

        verify(tg, times(1)).putString(Mockito.anyInt(), Mockito.anyInt(), Mockito.eq("X" + String.valueOf(powerUpValue)));
    }

    @Test
    void testInitGameGUI() {
        int animMode = 1;

        lanternaGUI.initGameGUI(animMode);

        verify(screen, Mockito.atLeastOnce()).setCharacter(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(TextCharacter.class));
    }

    @Test
    void testDrawTrack() {
        int xMargin = 2;
        int animMode = 1;
        TextColor borderColor = TextColor.ANSI.WHITE;

        lanternaGUI.drawTrack(xMargin, animMode, borderColor);

        verify(screen, Mockito.atLeastOnce()).setCharacter(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(TextCharacter.class));
    }

    @Test
    void testRefreshScreen() throws IOException {
        lanternaGUI.refreshScreen();

        verify(screen, times(1)).refresh();
    }

    @Test
    void testClearScreen() {
        lanternaGUI.clearScreen();

        verify(screen, times(1)).clear();
    }


    @Test
    void testInitMenuGUI() throws IOException {
        List<String> options = Arrays.asList("Option 1", "Option 2");
        int selected = 0;

        lanternaGUI.initMenuGUI(options, selected);

        verify(screen, times(1)).clear();
        verify(tg, times(options.size()+1)).putString(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    void testPutSurferSpeed() {
        int speed = 10;
        int maxSpeed = 20;

        lanternaGUI.putSurferSpeed(speed, maxSpeed);

        verify(tg, times(2)).putString(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    void testCloseScreen() throws IOException {
        lanternaGUI.closeScreen();

        verify(screen, times(1)).close();
    }

    @Test
    void testGetTerminalHeight() {
        int height = lanternaGUI.getTerminalHeight();

        assertEquals(40, height);
    }

    @Test
    void testGetCurrChar() throws IOException {
        char currChar = lanternaGUI.getCurrChar();

        assertEquals('a', currChar);
    }

    @Test
    void testSetCurrChar() throws IOException {
        char newChar = 'b';
        lanternaGUI.setCurrChar(newChar);

        char currChar = lanternaGUI.getCurrChar();
        assertEquals(newChar, currChar);
    }

    @Test
    void testGetSUI() {
        assertNotNull(lanternaGUI.getSUI());
    }

    @Test
    void testGetScreen() {
        assertEquals(screen, lanternaGUI.getScreen());
    }

    @Test
    void testSetScreen() {
        Screen newScreen = Mockito.mock(Screen.class);
        lanternaGUI.setScreen(newScreen);
        assertEquals(newScreen, lanternaGUI.getScreen());
    }

    @Test
    void testGetNextAction() throws IOException {
        GUI.ACTION action = lanternaGUI.getNextAction();
        assertEquals(GUI.ACTION.NONE, action);
    }

    @Test
    void testDrawMenu() throws IOException {
        List<String> options = Arrays.asList("Option 1", "Option 2");
        int selected = 0;

        lanternaGUI.drawMenu(options, selected);

        verify(tg, times(options.size()+1)).putString(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    void testDrawGameOver() throws IOException {
        Player player = Mockito.mock(Player.class);
        Mockito.when(player.getName()).thenReturn("Test");
        Mockito.when(player.getSavedScore()).thenReturn(100);
        Mockito.when(player.getEndSpeed()).thenReturn(10);
        List<String> options = Arrays.asList("Option 1", "Option 2");
        int selected = 0;

        lanternaGUI.drawGameOver(player, options, selected);

        verify(tg, times(8)).putString(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    void testDrawLeaderboard() {
        Player player = Mockito.mock(Player.class);
        Mockito.when(player.getName()).thenReturn("Test");
        Mockito.when(player.getSavedScore()).thenReturn(100);
        Mockito.when(player.getEndSpeed()).thenReturn(10);
        List<Player> listOfPlayers = Arrays.asList(player, player);

        lanternaGUI.drawLeaderboard(listOfPlayers);

        verify(tg, times(7)).putString(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    void testDrawInputName() throws IOException {
        String textInput = "Test";
        boolean invalidInputFlag = false;

        lanternaGUI.drawInputName(textInput, invalidInputFlag);

        verify(tg, times(8)).putString(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    void testDrawScoreIncrease() {
        int scoreIncrease = 10;
        int lineNum = 5;

        lanternaGUI.drawScoreIncrease(scoreIncrease, lineNum);

        verify(tg, times(1)).putString(Mockito.anyInt(), Mockito.anyInt(), Mockito.eq("+" + String.valueOf(scoreIncrease)));
    }

    @Test
    void testDrawSurferWithDifferentAnimModes() {
        Position position = Mockito.mock(Position.class);

        TextCharacter expectedCharacter1 = new TextCharacter('ª')
                .withForegroundColor(TextColor.ANSI.BLUE)
                .withBackgroundColor(new TextColor.RGB(188,187,156));
        lanternaGUI.drawSurfer(position, 1);
        verify(screen, times(1)).setCharacter(Mockito.anyInt(), Mockito.anyInt(), Mockito.eq(expectedCharacter1));

        TextCharacter expectedCharacter2 = new TextCharacter('©')
                .withForegroundColor(TextColor.ANSI.BLUE)
                .withBackgroundColor(new TextColor.RGB(188,187,156));
        lanternaGUI.drawSurfer(position, 2);
        verify(screen, times(1)).setCharacter(Mockito.anyInt(), Mockito.anyInt(), Mockito.eq(expectedCharacter2));

        TextCharacter expectedCharacter3 = new TextCharacter('ª')
                .withForegroundColor(TextColor.ANSI.BLUE)
                .withBackgroundColor(new TextColor.RGB(188,187,156));
        lanternaGUI.drawSurfer(position, 3);
        verify(screen, times(2)).setCharacter(Mockito.anyInt(), Mockito.anyInt(), Mockito.eq(expectedCharacter3));
    }

    @Test
    void testGetNextActionForArrowUp() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowUp);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = lanternaGUI.getNextAction();

        assertEquals(GUI.ACTION.UP, action);
    }

    @Test
    void testGetNextActionForArrowDown() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowDown);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = lanternaGUI.getNextAction();

        assertEquals(GUI.ACTION.DOWN, action);
    }

    @Test
    void testGetNextActionForArrowLeft() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowLeft);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = lanternaGUI.getNextAction();

        assertEquals(GUI.ACTION.LEFT, action);
    }

    @Test
    void testGetNextActionForArrowRight() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowRight);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = lanternaGUI.getNextAction();

        assertEquals(GUI.ACTION.RIGHT, action);
    }

    @Test
    void testGetNextActionForEnter() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Enter);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = lanternaGUI.getNextAction();

        assertEquals(GUI.ACTION.SELECT, action);
    }

    @Test
    void testGetNextActionForEscape() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Escape);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = lanternaGUI.getNextAction();

        assertEquals(GUI.ACTION.QUIT, action);
    }

    @Test
    void testGetNextActionForCharacter() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = lanternaGUI.getNextAction();

        assertEquals(GUI.ACTION.TYPING, action);
    }

    @Test
    void testGetNextActionForBackspace() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.Backspace);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = lanternaGUI.getNextAction();

        assertEquals(GUI.ACTION.UNDO, action);
    }

    @Test
    void testGetNextActionForEOF() throws IOException {
        KeyStroke keyStroke = Mockito.mock(KeyStroke.class);
        Mockito.when(keyStroke.getKeyType()).thenReturn(KeyType.EOF);
        Mockito.when(screen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = lanternaGUI.getNextAction();

        assertEquals(GUI.ACTION.QUIT, action);
    }

    @Test
    void testGetNextActionForNull() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(null);

        GUI.ACTION action = lanternaGUI.getNextAction();

        assertEquals(GUI.ACTION.NONE, action);
    }

    @Test
    void testDrawInputNameWithInvalidInput() throws IOException {
        String textInput = "Test";
        boolean invalidInputFlag = true;

        lanternaGUI.drawInputName(textInput, invalidInputFlag);

        verify(tg, times(11)).putString(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString());
    }

    @Test
    void testPutMultiplierWithMultiplierOff() {
        int powerUpValue = 2;
        boolean multiplierOn = false;

        lanternaGUI.putMultiplier(powerUpValue, multiplierOn);

        verify(tg, times(1)).setForegroundColor(TextColor.ANSI.BLACK);
        verify(tg, times(1)).setBackgroundColor(TextColor.ANSI.GREEN);
        verify(tg, times(1)).putString(Mockito.anyInt(), Mockito.anyInt(), Mockito.eq("X" + String.valueOf(powerUpValue)));
    }
}