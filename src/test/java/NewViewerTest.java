import org.crazytracks.gui.LanternaGUI;
import org.crazytracks.model.*;
import org.crazytracks.viewer.GameViewer;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class NewViewerTest {

    @Test
    public void testNewViewer() throws IOException, URISyntaxException, FontFormatException, InterruptedException {
        Track track = new Track();
        track.setSurfer(new Surfer(new Position(15, 30)));
        track.addTrackElement(new Wagon(new Position(15, 7)));
        track.addTrackElement(new Wagon(new Position(15, 8)));
        track.addTrackElement(new Wagon(new Position(15, 9)));
        track.addTrackElement(new Wagon(new Position(15, 10)));
        track.addTrackElement(new PowerUp(new Position(15, 25)));
        LanternaGUI gui = new LanternaGUI(30, 40);
        new GameViewer(track).draw(gui);
        Thread.sleep(10000);
    }
}
