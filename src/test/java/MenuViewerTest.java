import org.crazytracks.gui.LanternaGUI;
import org.crazytracks.model.Position;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.googlecode.lanterna.screen.Screen;
import org.crazytracks.gui.LanternaGUI;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class MenuViewerTest {
    private LanternaGUI lanternaGUI;
    private Screen screen;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    @BeforeEach
    public void setUp() {
        try {
            lanternaGUI = new LanternaGUI(30, 40);
        } catch (IOException | URISyntaxException | FontFormatException e) {
            e.printStackTrace();
        }
        lanternaGUI.clearScreen();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        try {
            if (screen != null) {
                screen.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // sleep for a while to see the screen after testing
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void drawingMenuTest() {
        int selected = 0;

        List<String> options = new ArrayList<>();
        options.add("Start");
        options.add("Exit");
        lanternaGUI.drawMenu(options, selected);
    }

}
