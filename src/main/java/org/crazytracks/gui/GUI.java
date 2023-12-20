package org.crazytracks.gui;

import com.googlecode.lanterna.TextColor;
import org.crazytracks.gui.sui.SUI;
import org.crazytracks.gui.sui.mainsound.MainSoundPlayer;
import org.crazytracks.model.Position;
import org.crazytracks.leaderboard.Player;
import org.crazytracks.model.Surfer;

import java.io.IOException;
import java.util.List;

public interface GUI {
    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, TYPING, UNDO}
    ACTION getNextAction() throws IOException;
    SUI sui = new MainSoundPlayer();
    SUI getSUI();
    char getCurrChar() throws IOException;
    void initGameGUI(int animMode);
    void drawTrack(int xMargin, int animMode, TextColor borderColor);
    void drawCoin(Position position);
    void drawSurfer(Surfer surfer);
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
    void drawInputName(String inputText);
    void clearScreen();
    void refreshScreen() throws IOException;
    void closeScreen() throws IOException;
}
