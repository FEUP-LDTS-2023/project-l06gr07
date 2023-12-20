package org.crazytracks.states;

import org.crazytracks.control.Controller;
import org.crazytracks.control.LeaderboardController;
import org.crazytracks.model.leaderboard.Leaderboard;
import org.crazytracks.viewer.LeaderboardViewer;
import org.crazytracks.viewer.Viewer;

public class LeaderboardState extends State<Leaderboard>{
    public LeaderboardState(Leaderboard model) {
        super(model);
    }

    @Override
    protected Viewer<Leaderboard> getViewer() {
        return new LeaderboardViewer(getModel());
    }

    @Override
    protected Controller<Leaderboard> getController() {
        return new LeaderboardController(getModel());
    }
}
