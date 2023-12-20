package org.crazytracks.model.track_element.coin;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;
import org.crazytracks.model.track_element.DrawStrategy;

public class CopperCoinDrawStrategy implements DrawStrategy {
    @Override
    public void draw(Element copperCoin, GUI gui) {
        gui.drawCopperCoin(copperCoin.getPosition());
    }
}
