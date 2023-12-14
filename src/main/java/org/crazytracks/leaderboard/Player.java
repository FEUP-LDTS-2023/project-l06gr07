package org.crazytracks.leaderboard;

public class Player {
    private int savedScore;
    private int maxSpeed;
    private String name;

    public Player(String name, int savedScore, int maxSpeed){
        this.savedScore = savedScore;
        this.maxSpeed = maxSpeed;
        this.name = name;
    }

    public int getSavedScore(){
        return savedScore;
    }

    public String getName(){
        return name;
    }
}
