package org.crazytracks.gui;

import org.crazytracks.model.Position;

import java.util.List;

public interface GUI {
    void initGameGUI();
    void drawCoin(Position position);
    void drawSurfer(Position position);
    void drawPowerUp(Position position);
    void drawWagon(Position position);
    void putScore(int score);
    void putMultiplier(int powerUpValue);
    void drawMenu(List<String> options, int selected);
    void clearScreen();
}
