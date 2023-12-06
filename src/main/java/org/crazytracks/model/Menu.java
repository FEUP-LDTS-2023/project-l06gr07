package org.crazytracks.model;

import java.util.Arrays;
import java.util.List;

public class Menu{

    private final List<String> entries;
    private int currentEntry = 0;

    public Menu() {
        this.entries = Arrays.asList("Start", "Exit");
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
}
