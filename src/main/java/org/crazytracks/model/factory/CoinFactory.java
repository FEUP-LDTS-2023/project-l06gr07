package org.crazytracks.model.factory;

import org.crazytracks.model.Coin;
import org.crazytracks.model.Element;
import org.crazytracks.model.Position;
import org.crazytracks.model.PowerUp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CoinFactory extends ElementFactory{
    @Override
    public List<Element> createElement() {
        List<Element> coins = new ArrayList<>();
        int randomLane = ThreadLocalRandom.current().nextInt(0,3);
        coins.add(new Coin(new Position(randomLane+14,0)));
        return coins;
    }
}
