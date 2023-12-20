package org.crazytracks.model.track_element.coin;

import org.crazytracks.model.track_element.DrawStrategy;
import org.crazytracks.model.track_element.Position;
import org.crazytracks.model.track_element.TrackElement;

public abstract class Coin extends TrackElement {
    public enum COLOR {BROWN, YELLOW}
    private final int coinValue;
    private final COLOR color;
    private final DrawStrategy drawStrategy;
    public Coin(Position position, int coinValue, COLOR color, DrawStrategy drawStrategy) {
        super(position);
        this.coinValue = coinValue;
        this.color = color;
        this.drawStrategy = drawStrategy;
    }
    public int getCoinValue(){
        return coinValue;
    }
    public COLOR getColor() {
        return color;
    }

    public DrawStrategy getDrawStrategy() {
        return drawStrategy;
    }
}
