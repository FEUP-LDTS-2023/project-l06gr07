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
    void putScore(int score);
    void putMultiplier(int powerUpValue);
    void drawMenu(List<String> options, int selected) throws IOException;
    void clearScreen();

<<<<<<< HEAD
    void refreshScreen() throws IOException;
=======
    void refreshScreen();
>>>>>>> 3cb26f2aa4fae63373b032e8ee4b20dacd93d81d
}
