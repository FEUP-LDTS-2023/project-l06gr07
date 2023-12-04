package org.crazytracks.gui;

import com.googlecode.lanterna.TextColor;
import org.crazytracks.model.Position;

import java.io.IOException;
import java.util.List;

public interface GUI {
    void initGameGUI();
    void drawTrack(int xMargin, int animMode, TextColor borderColor);
    void drawCoin(Position position);
    void drawSurfer(Position position);
    void drawPowerUp(Position position);
    void drawWagon(Position position);
    void putScore(int score) throws IOException;
    void putMultiplier(int powerUpValue) throws IOException;
    void drawMenu(List<String> options, int selected) throws IOException;
    void clearScreen();

    void refreshScreen() throws IOException;
}
