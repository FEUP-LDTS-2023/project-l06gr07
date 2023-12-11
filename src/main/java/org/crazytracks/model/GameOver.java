package org.crazytracks.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameOver {
    private final int score;
    private final List<String> entries;
    private int currentEntry;
    public GameOver(int score){
        this.score = score;
        this.entries = Arrays.asList("Try Again", "Back to Menu");
        this.currentEntry = 0;
    }
    public int getScore() {
        return score;
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

    public String getEntry(int i) {
        return entries.get(i);
    }

    public int getCurrentEntryIndex() {
        return currentEntry;
    }

    public boolean IsSelected(int entry) {
        return currentEntry == entry;
    }

    public boolean isSelectedStart() {
        return IsSelected(0);
    }

    public boolean isSelectedExit() {
        return IsSelected(1);
    }
}
