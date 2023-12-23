package org.crazytracks.model.track_element.coin;

import org.crazytracks.model.track_element.Position;
import org.crazytracks.viewer.coin.CopperCoinDrawStrategy;

public class CopperCoin extends Coin {
    public CopperCoin(Position position) {
        super(position, 50, new CopperCoinDrawStrategy());
    }
}
