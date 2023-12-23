package org.crazytracks.viewer.coin;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;
import org.crazytracks.model.track_element.coin.Coin;
import org.crazytracks.viewer.ElementViewer;

public class CoinViewer implements ElementViewer<Coin> {
    @Override
    public void draw(Element coin, GUI gui) {
        coin.getDrawStrategy().draw(coin, gui);
    }
}
