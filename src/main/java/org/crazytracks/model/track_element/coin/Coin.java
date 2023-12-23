package org.crazytracks.model.track_element.coin;

import org.crazytracks.viewer.coin.DrawStrategy;
import org.crazytracks.model.track_element.Position;
import org.crazytracks.model.track_element.TrackElement;

public abstract class Coin extends TrackElement {
    private final int coinValue;
    private final DrawStrategy drawStrategy;
    public Coin(Position position, int coinValue, DrawStrategy drawStrategy) {
        super(position);
        this.coinValue = coinValue;
        this.drawStrategy = drawStrategy;
    }
    public int getCoinValue(){
        return coinValue;
    }
    @Override
    public DrawStrategy getDrawStrategy() {
        return drawStrategy;
    }
}
