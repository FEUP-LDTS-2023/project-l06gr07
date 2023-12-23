package org.crazytracks.model.factory;

import org.crazytracks.model.Element;
import org.crazytracks.model.factory.WagonFactory;
import org.crazytracks.model.track_element.Wagon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WagonFactoryTest {
    private WagonFactory wagonFactory;

    @BeforeEach
    void setUp() {
        wagonFactory = new WagonFactory();
    }

    @Test
    void createElement() {
        List<Element> wagons = wagonFactory.createElement();

        assertFalse(wagons.isEmpty());

        Element wagon = wagons.get(0);
        assertTrue(wagon instanceof Wagon);
    }
}