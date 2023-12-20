package org.crazytracks.gui;

import com.googlecode.lanterna.TerminalPosition;
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
import org.crazytracks.gui.sui.SUI;
import org.crazytracks.model.Position;
import org.crazytracks.model.leaderboard.Player;
import org.crazytracks.model.Surfer;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.List;


public class LanternaGUI implements GUI {
    private final Screen screen;
    private final int terminalWidth;
    private final int terminalHeight;
    private final int numLanes = 3;
    private final int leftMargin;
    private final TextColor trackColor = new TextColor.RGB(188,187,156);
    PositionAdapter positionAdapter;
    private TrackAnimation animTrack;

    private char currChar;

    public LanternaGUI(int terminalWidth, int terminalHeight) throws IOException, URISyntaxException, FontFormatException {
        this.leftMargin = 14;
        this.terminalWidth = terminalWidth;
        this.terminalHeight = terminalHeight;

        Terminal terminal = terminalCreation(terminalWidth, terminalHeight);

        this.animTrack = null;

        this.currChar = 'a';

        this.screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        this.screen.startScreen();
        this.getSUI().playMusic();
    }

    public Terminal terminalCreation(int terminalWidth, int terminalHeight) throws IOException, FontFormatException, URISyntaxException {
//        URL resource = getClass().getClassLoader().getResource("fonts/AnonymousPro-Regular.ttf");
//        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        URL resource = getClass().getClassLoader().getResource("fonts/Square-Regular.ttf");
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
        paintOneBorder(x, (animMode+2)%4, bgColor);
    }

    private void paintOneBorder(int xMargin, int animMode, TextColor bgColor){
        TextCharacter block;
        for (int y = 0; y < terminalHeight; y++) {
            if (y%4 == animMode){
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
    public void drawSurfer(Position position, int animMode) {
        if (animMode == 0){
            TextCharacter surferCharacter = new TextCharacter('«')
                    .withForegroundColor(TextColor.ANSI.BLUE)
                    .withBackgroundColor(trackColor);
            putCharacter(position, surferCharacter);
        } else if (animMode == 1) {
            TextCharacter surferCharacter = new TextCharacter('ª')
                    .withForegroundColor(TextColor.ANSI.BLUE)
                    .withBackgroundColor(trackColor);
            putCharacter(position, surferCharacter);
        } else if (animMode == 2){
            TextCharacter surferCharacter = new TextCharacter('©')
                    .withForegroundColor(TextColor.ANSI.BLUE)
                    .withBackgroundColor(trackColor);
            putCharacter(position, surferCharacter);
        } else {
            TextCharacter surferCharacter = new TextCharacter('ª')
                    .withForegroundColor(TextColor.ANSI.BLUE)
                    .withBackgroundColor(trackColor);
            putCharacter(position, surferCharacter);
        }
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
    private void drawScoreIncrease(Integer scoreIncrease, int lineNum){
        TextGraphics textGraphics = screen.newTextGraphics();
        int x = 2;
        int y = lineNum + 4;
        textGraphics
                .setForegroundColor(TextColor.ANSI.GREEN_BRIGHT)
                .setBackgroundColor(TextColor.ANSI.GREEN);
        textGraphics.putString(x, y + 1, "+" + String.valueOf(scoreIncrease));
    }

    public void putScoreDisplayList(List<Integer> scoreDisplayList){
        for (int i = 0; i < scoreDisplayList.size(); i++){
            drawScoreIncrease(scoreDisplayList.get(i), i);
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
        textGraphics.putString(x, y, "Score:");
        textGraphics.putString(x, y + 1, String.valueOf(score));

    }

    @Override
    public void putMultiplier(int powerUpValue, boolean multiplierOn) {
        TextGraphics textGraphics = screen.newTextGraphics();
        int x = this.terminalWidth - 4;
        int y = 2;
        if (multiplierOn){
            textGraphics
                    .setForegroundColor(TextColor.ANSI.GREEN_BRIGHT)
                    .setBackgroundColor(TextColor.ANSI.GREEN);
            textGraphics.putString(x, y, "X" + String.valueOf(powerUpValue));
        } else {
            textGraphics
                    .setForegroundColor(TextColor.ANSI.BLACK)
                    .setBackgroundColor(TextColor.ANSI.GREEN);
            textGraphics.putString(x, y, "X" + String.valueOf(powerUpValue));
        }

    }

    @Override
    public void putSurferSpeed(int speed, int maxSpeed){
        putSurferSpeed(speed, maxSpeed, 2, this.terminalHeight - 5);
    }

    private void putSurferSpeed(int speed, int maxSpeed, int xMargin, int yMargin) {
        int x = xMargin;
        int y = yMargin;
        TextColor speedColor = getSpeedColor(speed, maxSpeed);
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics
                .setForegroundColor(TextColor.ANSI.BLACK)
                .setBackgroundColor(TextColor.ANSI.GREEN);
        textGraphics.putString(x, y, "Speed:");
        textGraphics
                .setForegroundColor(speedColor);
        textGraphics.putString(x, y + 1, String.valueOf(speed) + " Km/h");
    }

    private static TextColor getSpeedColor(int speed, int maxSpeed) {
        TextColor speedColor = null;
        int blackThreshold = maxSpeed / 4;
        int yellowThreshold = maxSpeed * 2 / 4;
        int redThreshold = maxSpeed * 3 / 4;
        if (speed > redThreshold){
            speedColor = TextColor.ANSI.RED;
        } else if (speed > yellowThreshold) {
            speedColor = TextColor.ANSI.YELLOW_BRIGHT;
        } else if (speed > blackThreshold) {
            speedColor = TextColor.ANSI.BLACK;
        } else {
            speedColor = TextColor.ANSI.BLUE;
        }
        return speedColor;
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
        if (this.animTrack == null) {
            this.animTrack = new TrackAnimation(this, trackLeftMargin, borderColor, this.terminalHeight);
            Thread animThread = new Thread(animTrack);
            animThread.start();
        }
        this.animTrack.drawTrackAnimation();
    }

    @Override
    public void drawGameOver(Player player, List<String> options, int selected) throws IOException {
        int xMargin = 3;
        putText("Game over,", xMargin, 5);
        putText(player.getName(), xMargin, 7);
        putScore(player.getSavedScore(), xMargin, 12);
        putSurferSpeed(player.getEndSpeed(), player.getEndSpeed()*3, xMargin, 18);
        paintOptions(xMargin, this.terminalHeight - 8, options, selected);
        this.animTrack.drawTrackAnimation();
    }
    private void putText(String text, int xMargin, int yMargin){
        putText(text, xMargin, yMargin, TextColor.ANSI.GREEN_BRIGHT, TextColor.ANSI.BLACK);
    }
    private void putText(String text, int xMargin, int yMargin, TextColor textColor, TextColor bgColor){
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics
                .setForegroundColor(textColor)
                .setBackgroundColor(bgColor);
        textGraphics.putString(xMargin, yMargin, text);
    }

    private void paintLogo(int xMargin, int yMargin){
        putText("CrazyTracks", xMargin, yMargin);
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

    public void drawLeaderboard(List<Player> listOfPlayers){
        int xMargin = 3;
        int currLine = 5;
        putText("Leaderboard", xMargin, currLine);
        currLine += 4;
        putText("Pos" + "  Name" + "           Score", xMargin-1, currLine);
        currLine += 2;
        int displayedPlayerNum = listOfPlayers.size();
        if (displayedPlayerNum > 23){
            displayedPlayerNum = 23;
        }
        for (int i = 0; i < displayedPlayerNum; i++){
            Player player = listOfPlayers.get(i);
            String nameDisplayed;
            int maxSizeOfName = 14;
            if (player.getName().length() <= maxSizeOfName) {
                nameDisplayed = player.getName();
            } else {
                nameDisplayed = player.getName().substring(0, maxSizeOfName) + "...";
            }
            putText(String.valueOf(i+1) + " " + nameDisplayed, xMargin-1, currLine + i);
            putText(String.valueOf(player.getSavedScore()), xMargin + 19, currLine + i);
        }

        List<String> options = Collections.singletonList("Back to Menu");
        paintOptions(3, this.terminalHeight - 5, options, 0);
    };

    public void drawInputName(String textInput){
        putText("You may have crashed...", 3, 5);
        putText("but your journey,", 3, 7);
        putText("shall never be forgotten.", 3, 9);
        putText("Write your name into", 3, 14);
        putText("history:", 3, 16);
        putText(textInput + "_", 3, 18, TextColor.ANSI.BLACK, TextColor.ANSI.GREEN_BRIGHT);
        putText("Press ENTER to submit", 3, this.terminalHeight - 7);
        putText("or ESC to exit", 3, this.terminalHeight - 5);
    }

    @Override
    public void clearScreen() {
        screen.clear();
    }

    public int getTerminalHeight() {
        return this.terminalHeight;
    }

    public char getCurrChar() throws IOException {
        return this.currChar;
    }

    public void setCurrChar(char nextChar){
        this.currChar = nextChar;
    }

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Escape) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character) {
            setCurrChar(keyStroke.getCharacter());
            return ACTION.TYPING;
        }
        if  (keyStroke.getKeyType() == KeyType.Backspace) return ACTION.UNDO;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
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

    @Override
    public SUI getSUI(){
        return sui;
    }
}


