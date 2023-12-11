package org.crazytracks.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
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
import java.util.List;

public class LanternaGUI implements GUI {
    private final Screen screen;
    private final int terminalWidth;
    private final int terminalHeight;
    private final int numLanes = 3;
    private final int leftMargin;
    private final TextColor trackColor = new TextColor.RGB(188,187,156);
    PositionAdapter positionAdapter;
    private boolean trackAnimCreated;
    private TrackAnimation animTrack;

    public LanternaGUI(int terminalWidth, int terminalHeight) throws IOException, URISyntaxException, FontFormatException {
        this.leftMargin = 14;
        this.terminalWidth = terminalWidth;
        this.terminalHeight = terminalHeight;

        Terminal terminal = terminalCreation(terminalWidth, terminalHeight);

        this.trackAnimCreated = false;

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
    public void initGameGUI(int animMode) {
        clearScreen();
        int trackHeight = this.terminalHeight;

        // Paint the grass
        TextCharacter solidBlock = new TextCharacter(' ').withBackgroundColor(TextColor.ANSI.GREEN);
        for (int y = 0; y < this.terminalHeight; y++) {
            for (int x = 0; x < this.terminalWidth; x++) {
                screen.setCharacter(x, y, solidBlock);
            }
        }
        TextColor borderColor = TextColor.ANSI.WHITE;
        drawTrack(this.leftMargin, animMode, borderColor);
    }

    public void drawTrack(int xMargin, int animMode, TextColor borderColor){
        // Paint the track
        TextCharacter block = new TextCharacter('H')
                .withForegroundColor(TextColor.ANSI.WHITE)
                .withBackgroundColor(trackColor);
        for (int y = 0; y < terminalHeight; y++) {
            for (int x = xMargin; x < xMargin + this.numLanes; x++) {
                screen.setCharacter(x, y, block);
            }
        }
        paintBorders(xMargin, animMode, borderColor);
    }

    private void paintBorders(int xMargin, int animMode, TextColor bgColor){
        // Paint the borders of track
        TextCharacter block;
        int x = xMargin-1;
        paintOneBorder(x, animMode, bgColor);
        x = xMargin + numLanes;
        paintOneBorder(x, (animMode+1)%2, bgColor);
    }

    private void paintOneBorder(int xMargin, int animMode, TextColor bgColor){
        TextCharacter block;
        for (int y = 0; y < terminalHeight; y++) {
            if (y%2 == animMode){
                block = new TextCharacter(':')
                        .withForegroundColor(TextColor.ANSI.BLACK)
                        .withBackgroundColor(bgColor);
                screen.setCharacter(xMargin, y, block);
            } else {
                block = new TextCharacter(' ')
                        .withForegroundColor(TextColor.ANSI.BLACK)
                        .withBackgroundColor(bgColor);
                screen.setCharacter(xMargin, y, block);
            }
        }
    }

    public void initMenuGUI(List<String> options, int selected) throws IOException {
        clearScreen();
        drawMenu(options, selected);
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
        if (position.getY() >= 0 && position.getY() < this.terminalHeight){
            if (position.getX() >= 0 && position.getX() < this.terminalWidth){
                screen.setCharacter(position.getX(), position.getY(), wagonCharacter);
            }
        }
    }
    @Override
    public void putScore(int score){ // default putScore()
        putScore(score, 2, 2);
    }
    @Override
    public void putScore(int score, int xMargin, int yMargin) {
        TextGraphics textGraphics = screen.newTextGraphics();
        int x = xMargin;
        int y = yMargin;
        textGraphics
                .setForegroundColor(TextColor.ANSI.BLACK)
                .setBackgroundColor(TextColor.ANSI.GREEN);
        textGraphics.putString(x, y, "Score: " + String.valueOf(score));
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
    }

    public void refreshScreen() throws IOException {
        screen.refresh();
    }

    @Override
    public void drawMenu(List<String> options, int selected) throws IOException {
        int logoTopMargin = 10;
        int textLeftMargin = 3;
        int textTopMargin = 8;

        int trackLeftMargin = 22;

        paintLogo(textLeftMargin, logoTopMargin);
        paintOptions(textLeftMargin, textTopMargin + logoTopMargin, options, selected);

        TextColor borderColor = TextColor.ANSI.GREEN;
        if (!this.trackAnimCreated) {
            this.animTrack = new TrackAnimation(this, trackLeftMargin, borderColor, this.terminalHeight);
            Thread animThread = new Thread(animTrack);
            animThread.start();
            this.trackAnimCreated = true;
        }
        this.animTrack.drawTrackAnimation();
    }

    @Override
    public void drawGameOver(int score, List<String> options, int selected) {
        paintGameOverText(5, 5);
        putScore(score, 5, 10);
        paintOptions(5, 15, options, selected);
    }
    private void paintGameOverText(int xMargin, int yMargin){
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics
                .setForegroundColor(TextColor.ANSI.GREEN_BRIGHT)
                .setBackgroundColor(TextColor.ANSI.BLACK);
        textGraphics.putString(xMargin, yMargin, "GameOver");
    }

    private void paintLogo(int xMargin, int yMargin){
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics
                .setForegroundColor(TextColor.ANSI.GREEN_BRIGHT)
                .setBackgroundColor(TextColor.ANSI.BLACK);
        textGraphics.putString(xMargin, yMargin, "CrazyTracks");
    }
    private void paintOptions(int xMargin, int yMargin, List<String> options, int selected){
        TextGraphics textGraphics;
        // draw the options in the screen
        for (int i = 0; i < options.size(); i++){
            textGraphics = screen.newTextGraphics();
            int y = i*2 + yMargin;
            if (selected == i){
                textGraphics
                        .setForegroundColor(TextColor.ANSI.BLACK)
                        .setBackgroundColor(TextColor.ANSI.WHITE);
            } else {
                textGraphics
                        .setForegroundColor(TextColor.ANSI.GREEN_BRIGHT)
                        .setBackgroundColor(TextColor.ANSI.BLACK);
            }
            textGraphics.putString(xMargin, y, options.get(i));
        }
    }

    @Override
    public void clearScreen() {
        screen.clear();
    }

    public int getTerminalHeight() {
        return this.terminalHeight;
    }

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) {
            System.out.print("up");
            return ACTION.UP;
        }
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }

    @Override
    public void closeScreen() throws IOException {
        screen.close();
    }
}


