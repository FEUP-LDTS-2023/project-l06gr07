package org.crazytracks;

import org.crazytracks.gui.GUI;
import org.crazytracks.gui.LanternaGUI;
import org.crazytracks.model.leaderboard.Leaderboard;
import org.crazytracks.model.Menu;
import org.crazytracks.states.MenuState;
import org.crazytracks.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;
    private final Leaderboard leaderboard;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(30, 40);
        this.state = new MenuState(new Menu());
        this.leaderboard = new Leaderboard(null);

        this.leaderboard.load();
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException, InterruptedException {
        new Game().start();
    }

    public GUI getGUI(){
        return this.gui;
    }

    public Leaderboard getLeaderboard(){
        return leaderboard;
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException, InterruptedException {
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            if (sleepTime > 0) Thread.sleep(sleepTime);
        }
        gui.getSUI().stopMusic();
        gui.closeScreen();
    }
}
