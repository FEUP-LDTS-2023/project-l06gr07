package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;
import org.crazytracks.model.track_element.coin.Coin;

public class CoinViewer implements ElementViewer<Coin> {
    @Override
    public void draw(Element coin, GUI gui) {
        coin.getDrawStrategy().draw(coin, gui);
    }
}
