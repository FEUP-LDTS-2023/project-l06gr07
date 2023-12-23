package org.crazytracks.viewer.coin;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;

public class CopperCoinDrawStrategy implements DrawStrategy {
    @Override
    public void draw(Element copperCoin, GUI gui) {
        gui.drawCopperCoin(copperCoin.getPosition());
    }
}
