package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.leaderboard.Leaderboard;

import java.io.IOException;

public class LeaderboardViewer extends Viewer<Leaderboard>{
    public LeaderboardViewer(Leaderboard model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        gui.drawLeaderboard(getModel().getListOfPlayers());
    }
}
