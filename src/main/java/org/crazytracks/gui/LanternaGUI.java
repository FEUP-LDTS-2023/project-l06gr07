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
    private final int terminalWidth;
    private final int terminalHeight;
    private final int numLanes = 3;
    private int leftMargin;
    private final TextColor trackColor = new TextColor.RGB(188,187,156);
    PositionAdapter positionAdapter;
    public LanternaGUI(int terminalWidth, int terminalHeight) throws IOException, URISyntaxException, FontFormatException {
        this.leftMargin = 14;
        this.terminalWidth = terminalWidth;
        this.terminalHeight = terminalHeight;

        Terminal terminal = terminalCreation(terminalWidth, terminalHeight);

        this.screen = new TerminalScreen(terminal);
        this.screen.startScreen();
    }

    public Terminal terminalCreation(int terminalWidth, int terminalHeight) throws IOException, FontFormatException, URISyntaxException {
//        URL resource = getClass().getClassLoader().getResource("fonts/AnonymousPro-Regular.ttf");
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font =  Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        DefaultTerminalFactory factory = new DefaultTerminalFactory();

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        factory.setTerminalEmulatorFontConfiguration(fontConfig);
        factory.setForceAWTOverSwing(true);
        factory.setInitialTerminalSize(new TerminalSize(terminalWidth, terminalHeight));
        return factory.createTerminal();
    }

    @Override
    public void initGameGUI() {
        int trackHeight = this.terminalHeight;

        // Paint the grass
        TextCharacter solidBlock = new TextCharacter(' ').withBackgroundColor(TextColor.ANSI.GREEN);
        for (int y = 0; y < this.terminalHeight; y++) {
            for (int x = 0; x < this.terminalWidth; x++) {
                screen.setCharacter(x, y, solidBlock);
            }
        }

        // Paint the track
        solidBlock = new TextCharacter('H')
                .withForegroundColor(TextColor.ANSI.WHITE)
                .withBackgroundColor(trackColor);
        for (int y = 0; y < trackHeight; y++) {
            for (int x = this.leftMargin; x < this.leftMargin + this.numLanes; x++) {
                screen.setCharacter(x, y, solidBlock);
            }
        }

        // Paint the borders of track
        solidBlock = new TextCharacter(':')
                .withForegroundColor(TextColor.ANSI.BLACK)
                .withBackgroundColor(TextColor.ANSI.GREEN);
        int x = this.leftMargin-1;
        for (int y = 0; y < this.terminalHeight; y++) {
            screen.setCharacter(x, y, solidBlock);
        }
        x = this.leftMargin + this.numLanes;
        for (int y = 0; y < this.terminalHeight; y++) {
            screen.setCharacter(x, y, solidBlock);
        }

        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawCoin(Position position) {
        TextCharacter coinCharacter = new TextCharacter('$')
                .withForegroundColor(TextColor.ANSI.YELLOW)
                .withBackgroundColor(TextColor.ANSI.WHITE);
        putCharacter(position, coinCharacter);
    }

    @Override
    public void drawSurfer(Position position) {
        TextCharacter surferCharacter = new TextCharacter('S')
                .withForegroundColor(TextColor.ANSI.BLUE)
                .withBackgroundColor(trackColor);
        putCharacter(position, surferCharacter);
    }

    @Override
    public void drawPowerUp(Position position) {
        TextCharacter powerUpCharacter = new TextCharacter('p')
                .withForegroundColor(TextColor.ANSI.GREEN)
                .withBackgroundColor(TextColor.ANSI.WHITE);
        putCharacter(position, powerUpCharacter);
    }

    @Override
    public void drawWagon(Position position) {
        TextCharacter wagonCharacter = new TextCharacter('|')
                .withForegroundColor(TextColor.ANSI.BLACK)
                .withBackgroundColor(TextColor.ANSI.RED);
        putCharacter(position, wagonCharacter);
    }

    private void putCharacter(Position position, TextCharacter wagonCharacter) {
        PositionAdapter positionAdapter = new PositionAdapter(this.leftMargin, this.terminalHeight-1);
        Position adaptedPosition = positionAdapter.adaptPosition(position);
        screen.setCharacter(adaptedPosition.getX(), adaptedPosition.getY(), wagonCharacter);

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
        textGraphics
                .setForegroundColor(TextColor.ANSI.BLACK)
                .setBackgroundColor(TextColor.ANSI.GREEN);
        textGraphics.putString(x, y, "Score: " + String.valueOf(score));

        try {
            screen.refresh();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void putMultiplier(int powerUpValue) {
        TextGraphics textGraphics = screen.newTextGraphics();
        int x = this.terminalWidth - 6;
        int y = 2;
        textGraphics
                .setForegroundColor(TextColor.ANSI.BLACK)
                .setBackgroundColor(TextColor.ANSI.GREEN);
        textGraphics.putString(x, y, "X" + String.valueOf(powerUpValue));

        try {
            screen.refresh();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
