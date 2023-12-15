package org.crazytracks.leaderboard;

import java.util.Arrays;
import java.util.List;

public class LeaderboardLoader {
    private String filepath;
    public LeaderboardLoader(String filepath){
        this.filepath = filepath; // for future implementation of persistent data
    }

    public Leaderboard load(){
        List<Player> newListPlayers = Arrays.asList(
                new Player("John Doe", 10, 11),
                new Player("Jane Doe", 19, 13),
                new Player("Somebody else Doe", 31, 23)
        );
        return new Leaderboard(newListPlayers);
    }
}
