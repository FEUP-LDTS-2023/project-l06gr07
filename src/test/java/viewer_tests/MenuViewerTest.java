package viewer_tests;

import org.crazytracks.gui.GUI;
import org.crazytracks.gui.LanternaGUI;
import org.crazytracks.model.Menu;
import org.crazytracks.viewer.MenuViewer;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


public class MenuViewerTest {
    @Test
    public void menuViewerTest() throws InterruptedException, IOException, URISyntaxException, FontFormatException {
        Menu menu = new Menu();
        MenuViewer viewer = new MenuViewer(menu);
        GUI gui = new LanternaGUI(30, 40);
        viewer.draw(gui);
        Thread.sleep(10000);
    }
}

