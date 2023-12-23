package org.crazytracks.model;

import org.crazytracks.model.Element;
import org.crazytracks.model.track_element.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ElementTest {
    private Element element;

    @BeforeEach
    public void setUp(){
        Position mockPosition = Mockito.mock(Position.class);
        Mockito.when(mockPosition.getX()).thenReturn(5);
        Mockito.when(mockPosition.getY()).thenReturn(5);
        this.element = new Element(mockPosition);
    }

    @Test
    public void testGetLeftPosition() {
        Position leftPosition = element.getLeftPosition();
        Assertions.assertEquals(4, leftPosition.getX());
        Assertions.assertEquals(5, leftPosition.getY());
    }

    @Test
    public void testGetRightPosition() {
        Position rightPosition = element.getRightPosition();
        Assertions.assertEquals(6, rightPosition.getX());
        Assertions.assertEquals(5, rightPosition.getY());
    }

    @Test
    public void testGetUpPosition() {
        Position upPosition = element.getUpPosition();
        Assertions.assertEquals(5, upPosition.getX());
        Assertions.assertEquals(4, upPosition.getY());
    }

    @Test
    public void testGetDownPosition() {
        Position downPosition = element.getDownPosition();
        Assertions.assertEquals(5, downPosition.getX());
        Assertions.assertEquals(6, downPosition.getY());
    }
}
