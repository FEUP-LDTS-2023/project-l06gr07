package org.crazytracks.model.factory;

import org.crazytracks.model.Element;
import org.crazytracks.model.track_element.Position;
import org.crazytracks.model.track_element.PowerUp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PowerUpFactory extends ElementFactory{
    @Override
    public List<Element> createElement() {
        List<Element> powerUps = new ArrayList<>();
        int randomLane = ThreadLocalRandom.current().nextInt(0,3);
        powerUps.add(new PowerUp(new Position(randomLane+14,0)));
        return powerUps;
    }
}
