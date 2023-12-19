package org.crazytracks.model;

public class Coin extends TrackElement {
    private final int coinValue;
    public Coin(Position position) {
        super(position);
        this.coinValue = 50;
    }
    public int getCoinValue(){
        return coinValue;
    }
}
