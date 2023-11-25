import com.googlecode.lanterna.screen.Screen;
import org.crazytracks.gui.LanternaGUI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ViewerTest {
    private LanternaGUI lanternaGUI;
    private Screen screen;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        try {
            lanternaGUI = new LanternaGUI();
            lanternaGUI.initGameGUI();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGUIInitialization() {

    }
}