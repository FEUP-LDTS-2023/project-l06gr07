package org.crazytracks.leaderboard;

import java.util.*;

public class LeaderboardLoader {
    private String filepath;
    public LeaderboardLoader(String filepath){
        this.filepath = filepath; // for future implementation of persistent data
    }

    public Leaderboard load(){
        List<Player> newListPlayers = new ArrayList<>();
        newListPlayers.add(new Player("John Doe", 10, 11));
        newListPlayers.add(new Player("Jane Doe", 19, 13));
        newListPlayers.add(new Player("Somebody else Doe", 31, 23));
        Collections.sort(newListPlayers, Comparator.comparingInt(Player::getSavedScore).reversed());
        return new Leaderboard(newListPlayers);
    }
}
