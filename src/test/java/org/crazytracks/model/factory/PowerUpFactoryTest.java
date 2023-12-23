package org.crazytracks.model.factory;

import org.crazytracks.model.Element;
import org.crazytracks.model.factory.PowerUpFactory;
import org.crazytracks.model.track_element.PowerUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PowerUpFactoryTest {
    private PowerUpFactory powerUpFactory;

    @BeforeEach
    void setUp() {
        powerUpFactory = new PowerUpFactory();
    }

    @Test
    void testCreateElement() {
        List<Element> powerUps = powerUpFactory.createElement();

        // Check that a power-up was created
        assertFalse(powerUps.isEmpty());

        // Check that the created power-up is of the correct type
        Element powerUp = powerUps.get(0);
        assertTrue(powerUp instanceof PowerUp);
    }
}