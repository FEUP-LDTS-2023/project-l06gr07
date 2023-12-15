package org.crazytracks.leaderboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leaderboard {
    private final List<String> entries;
    private int currentEntry;
    private List<Player> listOfPlayers;
    public Leaderboard(List<Player> listOfPlayers){
        this.listOfPlayers = listOfPlayers;
        this.entries = Arrays.asList("Back to Menu");
        this.currentEntry = 0;
    }
    public void insertPlayer(Player playerToInsert){
        this.listOfPlayers.add(playerToInsert);
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
