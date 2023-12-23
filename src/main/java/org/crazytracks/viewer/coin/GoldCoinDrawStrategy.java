package org.crazytracks.viewer.coin;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;

public class GoldCoinDrawStrategy implements DrawStrategy {
    @Override
    public void draw(Element goldCoin, GUI gui) {
        gui.drawGoldCoin(goldCoin.getPosition());
    }
}
