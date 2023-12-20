package org.crazytracks.model.leaderboard;

public class Player {
    private final int savedScore;
    private final int endSpeed;
    private final String name;

    public Player(String name, int savedScore, int endSpeed){
        this.savedScore = savedScore;
        this.endSpeed = endSpeed;
        this.name = name;
    }

    public int getSavedScore(){
        return savedScore;
    }

    public int getEndSpeed() {
        return endSpeed;
    }

    public String getName(){
        return name;
    }
}
