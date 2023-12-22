package viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.leaderboard.Leaderboard;
import org.crazytracks.model.leaderboard.Player;
import org.crazytracks.viewer.LeaderboardViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeaderboardViewerTest {
    private Leaderboard leaderboard;
    private LeaderboardViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(GUI.class);

        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("Player1", 10000,25));
        playerList.add(new Player("Player2", 5000,20));
        playerList.add(new Player("Player3", 1000,15));

        leaderboard = new Leaderboard(playerList);
        viewer = new LeaderboardViewer(leaderboard);
    }

    @Test
    void testDraw() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawLeaderboard(Mockito.anyList());
    }
}
