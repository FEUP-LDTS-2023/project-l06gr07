package org.crazytracks.leaderboard;

public class Player {
    private int savedScore;
    private String name;
    public Player(String name, int savedScore){
        this.savedScore = savedScore;
        this.name = name;
    }
    public int getSavedScore(){
        return savedScore;
    }

    public String getName(){
        return name;
    }
}
