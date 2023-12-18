package org.crazytracks.gui;

import com.googlecode.lanterna.TextColor;
import org.crazytracks.model.Position;
import org.crazytracks.leaderboard.Player;

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
    void putScoreDisplayList(List<Integer> scoreDisplayList);
    void putScore(int score);
    void putScore(int score, int xMargin, int yMargin);
    void putMultiplier(int powerUpValue, boolean multiplierOn);
    void putSurferSpeed(int score, int endSpeed);
    void drawMenu(List<String> options, int selected) throws IOException;
    void drawGameOver(int score, int endSpeed, List<String> options, int selected);
    void drawLeaderboard(List<Player> listOfPlayers);
    void drawInputName();
    void clearScreen();
    void refreshScreen() throws IOException;
    void closeScreen() throws IOException;
}
