package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Coin;
import org.crazytracks.model.Element;

public class CoinViewer implements ElementViewer<Coin> {

    @Override
    public void draw(Element coin, GUI gui) {
        gui.drawCoin(coin.getPosition());
    }
}
