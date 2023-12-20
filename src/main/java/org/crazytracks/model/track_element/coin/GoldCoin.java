package org.crazytracks.model.track_element.coin;

import org.crazytracks.model.track_element.Position;
import org.crazytracks.model.track_element.coin.Coin;

public class GoldCoin extends Coin {
    public GoldCoin(Position position) {
        super(position, 250, COLOR.YELLOW, new GoldCoinDrawStrategy());
    }
}
