package org.crazytracks.gui.track_animation;

import org.crazytracks.gui.track_animation.PositionAdapter;
import org.crazytracks.model.track_element.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositionAdapterTest {
    @Test
    public void adaptPosition(){
        Position position = new Position(15, 5);
        Position expected = new Position(20, -3);

        PositionAdapter positionAdapter = new PositionAdapter(5, 2);
        Position guiPos = positionAdapter.adaptPosition(position);

        Assertions.assertEquals(guiPos.getX(), expected.getX());
        Assertions.assertEquals(guiPos.getY(), expected.getY());

    }
}
