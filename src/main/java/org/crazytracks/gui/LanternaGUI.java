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
import java.io.IOException;

public class LanternaGUI implements GUI {
    private final Screen screen;
    private final int terminalWidth;
    private final int terminalHeight;
    private int leftMargin;
    PositionAdapter positionAdapter;
    public LanternaGUI(int terminalWidth, int terminalHeight) throws IOException {
        this.leftMargin = 14;
        this.terminalWidth = terminalWidth;
        this.terminalHeight = terminalHeight;

        Font myFont = new Font("Monospaced", Font.PLAIN, 20);
        AWTTerminalFontConfiguration myFontConfiguration = AWTTerminalFontConfiguration.newInstance(myFont);
        DefaultTerminalFactory dtf = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(terminalWidth, terminalHeight));
        dtf.setForceAWTOverSwing(true);
        dtf.setTerminalEmulatorFontConfiguration(myFontConfiguration);
        Terminal terminal = dtf.createTerminal();

        this.screen = new TerminalScreen(terminal);
        this.screen.startScreen();
    }

    @Override
    public void initGameGUI() {

        int trackWidth = 3;
        int trackHeight = this.terminalHeight;

        TextCharacter solidBlock = new TextCharacter(' ').withBackgroundColor(TextColor.ANSI.WHITE);

        for (int y = 0; y < trackHeight; y++) {
            for (int x = this.leftMargin; x < this.leftMargin + trackWidth; x++) {
                screen.setCharacter(x, y, solidBlock);
            }
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
        TextCharacter surferCharacter = new TextCharacter('O')
                .withForegroundColor(TextColor.ANSI.BLUE)
                .withBackgroundColor(TextColor.ANSI.WHITE);
        putCharacter(position, surferCharacter);
    }

    @Override
    public void drawPowerUp(Position position) {
        TextCharacter powerUpCharacter = new TextCharacter('↑')
                .withForegroundColor(TextColor.ANSI.GREEN)
                .withBackgroundColor(TextColor.ANSI.WHITE);
        putCharacter(position, powerUpCharacter);
    }

    @Override
    public void drawWagon(Position position) {
        TextCharacter wagonCharacter = new TextCharacter('H')
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
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.putString(x, y, "Score: " + String.valueOf(score));

        try {
            screen.refresh();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
