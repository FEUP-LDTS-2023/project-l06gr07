package org.crazytracks.model;

import org.crazytracks.leaderboard.Player;

import java.util.Arrays;
import java.util.List;

public class GameOver {
    private final Player player;
    private final List<String> entries;
    private int currentEntry;

    public GameOver(Player player){
        this.player = player;

        this.entries = Arrays.asList("Try Again", "Back to Menu");
        this.currentEntry = 0;
    }
    public Player getPlayer(){
        return player;
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
