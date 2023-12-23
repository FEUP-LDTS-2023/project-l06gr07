package org.crazytracks.model.track_element;

import org.crazytracks.model.track_element.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position(0, 0);
    }

    @Test
    void testGetXAndY() {
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
    }

    @Test
    void testSetXAndY() {
        position.setX(1);
        position.setY(2);
        assertEquals(1, position.getX());
        assertEquals(2, position.getY());
    }

    @Test
    void testEquals() {
        Position samePosition = new Position(0, 0);
        Position differentPosition = new Position(1, 2);
        assertEquals(position, samePosition);
        assertNotEquals(position, differentPosition);
    }

    @Test
    void testHashCode() {
        Position samePosition = new Position(0, 0);
        Position differentPosition = new Position(1, 2);
        assertEquals(position.hashCode(), samePosition.hashCode());
        assertNotEquals(position.hashCode(), differentPosition.hashCode());
    }
}