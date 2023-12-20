package org.crazytracks.model.track_element.coin;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;
import org.crazytracks.model.track_element.DrawStrategy;

public class GoldCoinDrawStrategy implements DrawStrategy {
    @Override
    public void draw(Element goldCoin, GUI gui) {
        gui.drawGoldCoin(goldCoin.getPosition());
    }
}
