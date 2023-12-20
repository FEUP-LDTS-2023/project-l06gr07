package org.crazytracks.model.leaderboard;

import java.util.*;

public class Leaderboard {
    private final List<String> entries;
    private int currentEntry;
    private List<Player> listOfPlayers;
    private final LeaderboardLoader ll;
    public Leaderboard(List<Player> listOfPlayers){
        this.ll = new LeaderboardLoader("src/main/resources/leaderboard/leaderboard.txt");
        this.listOfPlayers = ll.loadList();

        this.entries = Collections.singletonList("Back to Menu");
        this.currentEntry = 0;
    }
    public void insertPlayer(Player playerToInsert){
        this.listOfPlayers.add(playerToInsert);
        this.listOfPlayers.sort(Comparator.comparingInt(Player::getSavedScore).reversed());
        ll.save(this);

    }
    public void save() {
        ll.save(this);
    }
    public void load(){
        this.listOfPlayers = ll.loadList();
    }
    public List<Player> getListOfPlayers() {
        return listOfPlayers;
    }
    public List<String> getEntries() {
        return entries;
    }
    public String getCurrentEntry() {
        return entries.get(currentEntry);
    }
    public void nextEntry() {
        currentEntry = (currentEntry + 1) % entries.size();
    }
    public void previousEntry() {
        currentEntry = (currentEntry - 1 + entries.size()) % entries.size();
    }
    public int getCurrentEntryIndex() {
        return currentEntry;
    }
}
