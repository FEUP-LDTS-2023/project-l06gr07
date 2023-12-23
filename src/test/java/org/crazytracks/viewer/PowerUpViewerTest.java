package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.track_element.Position;
import org.crazytracks.model.track_element.PowerUp;
import org.crazytracks.viewer.PowerUpViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PowerUpViewerTest {
    private PowerUp powerUp;
    private PowerUpViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        powerUp = new PowerUp(new Position(15, 0));
        gui = Mockito.mock(GUI.class);
        viewer = new PowerUpViewer();
    }

    @Test
    void testDraw() {
        viewer.draw(powerUp, gui);
        Mockito.verify(gui).drawPowerUp(powerUp.getPosition());
    }
}
