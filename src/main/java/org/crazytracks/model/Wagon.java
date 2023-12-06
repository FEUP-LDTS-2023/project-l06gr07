package org.crazytracks.model;

public class Wagon extends TrackElement {
    int wagon_lenght;
    public Wagon(Position position) {
        super(position);
    }
    public CollisionStrategy createCollisionStrategy() {
        return new EndGameCollisionStrategy();
    }
    public int getWagon_lenght() {
        return wagon_lenght;
    }
    public void setWagon_lenght(int wagon_lenght) {
        this.wagon_lenght = wagon_lenght;
    }

}
