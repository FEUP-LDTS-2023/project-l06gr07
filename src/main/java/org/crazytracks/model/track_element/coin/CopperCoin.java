package org.crazytracks.model.track_element.coin;

import org.crazytracks.model.track_element.Position;
import org.crazytracks.model.track_element.coin.Coin;

public class CopperCoin extends Coin {
    public CopperCoin(Position position) {
        super(position, 50, COLOR.BROWN, new CopperCoinDrawStrategy());
    }
}
