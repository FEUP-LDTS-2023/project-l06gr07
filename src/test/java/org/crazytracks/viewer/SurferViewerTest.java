package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Animation;
import org.crazytracks.model.Surfer;
import org.crazytracks.model.track_element.Position;
import org.crazytracks.viewer.SurferViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SurferViewerTest {
    private Surfer surfer;
    private SurferViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        surfer = new Surfer(new Position(15, 30));
        Animation anim = new Animation(4);
        surfer.setAnim(anim);
        gui = Mockito.mock(GUI.class);
        viewer = new SurferViewer();
    }

    @Test
    void testDraw() {
        viewer.draw(surfer, gui);
        Mockito.verify(gui).drawSurfer(surfer.getPosition(),0);
    }
}
