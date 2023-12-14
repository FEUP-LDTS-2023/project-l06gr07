package org.crazytracks.leaderboard;

import java.util.ArrayList;
import java.util.List;

public class Leaderboard {
    private List<Player> listOfPlayers;
    public Leaderboard(){
        this.listOfPlayers = new ArrayList<>();
    }
    public void insertPlayer(Player playerToInsert){
        this.listOfPlayers.add(playerToInsert);
    }
    public List<Player> getListOfPlayers() {
        return listOfPlayers;
    }
}
