package org.crazytracks.model.factory;

import org.crazytracks.model.Element;
import org.crazytracks.model.track_element.Position;
import org.crazytracks.model.track_element.coin.CopperCoin;
import org.crazytracks.model.track_element.coin.GoldCoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CoinFactory extends ElementFactory{
    @Override
    public List<Element> createElement() {
        List<Element> coins = new ArrayList<>();
        int randomLane = ThreadLocalRandom.current().nextInt(0,3);
        int coinChoice = ThreadLocalRandom.current().nextInt(0,20);
        if (coinChoice == 0){
            coins.add(new GoldCoin(new Position(randomLane+14,0)));
        } else {
            coins.add(new CopperCoin(new Position(randomLane+14,0)));
        }
        return coins;
    }
}
