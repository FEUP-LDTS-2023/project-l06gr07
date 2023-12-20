package org.crazytracks.model.factory;

import org.crazytracks.model.Element;
import org.crazytracks.model.track_element.Position;
import org.crazytracks.model.track_element.Wagon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WagonFactory  extends ElementFactory{
    @Override
    public List<Element> createElement() {
        List<Element> wagons = new ArrayList<>();
        int randomSize = ThreadLocalRandom.current().nextInt(5,8);
        int randomLane = ThreadLocalRandom.current().nextInt(0,3);
        for (int i = 0; i < randomSize; i++) {
            wagons.add(new Wagon(new Position(randomLane+14, -i)));
        }
        return wagons;
    }
}
