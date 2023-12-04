import org.crazytracks.gui.LanternaGUI;
import org.crazytracks.model.Menu;
import org.crazytracks.model.Position;
import org.crazytracks.model.Track;
import org.crazytracks.viewer.MenuViewer;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class NewMenuTest {
    @Test
    public void menuTest() throws InterruptedException, IOException, URISyntaxException, FontFormatException {
        Menu menu = new Menu();
        LanternaGUI gui = new LanternaGUI(30, 40);
        new MenuViewer(menu).draw(gui);
        Thread.sleep(10000);
    }
}
