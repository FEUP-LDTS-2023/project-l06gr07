package viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.track_element.Position;
import org.crazytracks.model.track_element.Wagon;
import org.crazytracks.viewer.Viewer;
import org.crazytracks.viewer.WagonViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class WagonViewerTest {
    private Wagon wagon;
    private WagonViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        wagon = new Wagon(new Position(15, 0));
        gui = Mockito.mock(GUI.class);
        viewer = new WagonViewer();
    }

    @Test
    void testDraw() {
        viewer.draw(wagon, gui);
        Mockito.verify(gui).drawWagon(wagon.getPosition());
    }
}
