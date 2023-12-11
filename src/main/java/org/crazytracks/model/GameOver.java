package org.crazytracks.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameOver {
    private final int score;
    private final List<String> options;
    private int selected;
    public GameOver(int score){
        this.score = score;
        this.options = Arrays.asList("Try Again", "Back to Menu");
        this.selected = 0;
    }
    public int getScore() {
        return score;
    }
    public List<String> getOptions() {
        return options;
    }
    public int getSelected(){
        return selected;
    }
}
