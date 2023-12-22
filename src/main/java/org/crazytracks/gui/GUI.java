package org.crazytracks.gui;

import com.googlecode.lanterna.TextColor;
import org.crazytracks.gui.sui.SUI;
import org.crazytracks.gui.sui.mainsound.MainSoundPlayer;
import org.crazytracks.model.track_element.Position;
import org.crazytracks.model.leaderboard.Player;

import java.io.IOException;
import java.util.List;

public interface GUI {
    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, TYPING, UNDO}
    ACTION getNextAction() throws IOException;
    SUI getSUI();
    char getCurrChar() throws IOException;
    void initGameGUI(int animMode);
    void drawTrack(int xMargin, int animMode, TextColor borderColor);

    void drawCopperCoin(Position position);
    void drawGoldCoin(Position position);

    void drawSurfer(Position position, int animMode);
    void drawPowerUp(Position position);
    void drawWagon(Position position);
    void putScoreDisplayList(List<Integer> scoreDisplayList);
    void putScore(int score);
    void putScore(int score, int xMargin, int yMargin);
    void putMultiplier(int powerUpValue, boolean multiplierOn);
    void putSurferSpeed(int score, int endSpeed);
    void drawMenu(List<String> options, int selected) throws IOException;
    void drawGameOver(Player player, List<String> options, int selected) throws IOException;
    void drawLeaderboard(List<Player> listOfPlayers);
    void drawInputName(String inputText, boolean invalidInputFlag);
    void clearScreen();
    void refreshScreen() throws IOException;
    void closeScreen() throws IOException;
}
