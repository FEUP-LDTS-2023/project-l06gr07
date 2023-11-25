package org.crazytracks.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import org.crazytracks.model.Position;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private final Screen screen;
    private final int terminalWidth = 30;
    private final int terminalHeight = 40;
    public LanternaGUI() throws IOException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(terminalWidth, terminalHeight));
        Terminal terminal = terminalFactory.createTerminal();
        this.screen = new TerminalScreen(terminal);
        this.screen.startScreen();
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = null;
        try {
            fontFile = new File(resource.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        }

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }

    @Override
    public void drawElement(Object view) {

    }

    @Override
    public void initGameGUI() {

        int leftMargin = 15;
        int trackWidth = 3;
        int trackHeight = this.terminalHeight;

        TextCharacter solidBlock = new TextCharacter('█').withForegroundColor(TextColor.ANSI.WHITE);

        for (int y = 0; y < trackHeight; y++) {
            for (int x = leftMargin; x < leftMargin + trackWidth; x++) {
                screen.setCharacter(x, y, solidBlock);
            }
        }

        try {
            screen.refresh(); // Refresh the screen to display changes
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawCoin(Position position) {
        TextCharacter coinCharacter = new TextCharacter('$')
                .withForegroundColor(TextColor.ANSI.YELLOW)
                .withBackgroundColor(TextColor.ANSI.WHITE);
        screen.setCharacter(position.getX(), position.getY(), coinCharacter);

        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawSurfer(Position position) {
        TextCharacter surferCharacter = new TextCharacter('웃')
                .withForegroundColor(TextColor.ANSI.BLUE)
                .withBackgroundColor(TextColor.ANSI.WHITE);
        screen.setCharacter(position.getX(), position.getY(), surferCharacter);

        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawPowerUp(Position position) {
        TextCharacter powerUpCharacter = new TextCharacter('↑')
                .withForegroundColor(TextColor.ANSI.GREEN)
                .withBackgroundColor(TextColor.ANSI.WHITE);
        screen.setCharacter(position.getX(), position.getY(), powerUpCharacter);

        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawWagon(Position position) {
        TextCharacter coinCharacter = new TextCharacter('▥')
                .withForegroundColor(TextColor.ANSI.RED)
                .withBackgroundColor(TextColor.ANSI.WHITE);
        screen.setCharacter(position.getX(), position.getY(), coinCharacter);

        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void putScore(int score) {
        TextGraphics textGraphics = screen.newTextGraphics();

        int x = 2;
        int y = 2;
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.putString(x, y, "Score: " + String.valueOf(score));

        try {
            screen.refresh(); // Refresh the screen to display changes
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
