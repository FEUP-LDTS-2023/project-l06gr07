package org.crazytracks.gui;

import com.googlecode.lanterna.TextColor;
import org.crazytracks.model.Position;

import java.io.IOException;
import java.util.List;

public interface GUI {
    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
    ACTION getNextAction() throws IOException;

    void initGameGUI(int animMode);

    void drawTrack(int xMargin, int animMode, TextColor borderColor);
    void drawCoin(Position position);
    void drawSurfer(Position position);
    void drawPowerUp(Position position);
    void drawWagon(Position position);
    void putScore(int score);
    void putMultiplier(int powerUpValue);
    void drawMenu(List<String> options, int selected) throws IOException;
    void drawGameOverMenu(int score);
    void clearScreen();
    void refreshScreen() throws IOException;
    void closeScreen() throws IOException;
}
