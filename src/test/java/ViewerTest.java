import com.googlecode.lanterna.screen.Screen;
import org.crazytracks.gui.LanternaGUI;
import org.crazytracks.model.Position;
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

//    @Test
//    public void testGUIInitialization() {
//
//    }

    @Test
    public void elementDrawerTest() {
        Position coinPosition = new Position(17, 5);
        Position surferPosition = new Position(16, 30);

        lanternaGUI.drawCoin(coinPosition);
        lanternaGUI.drawSurfer(surferPosition);
        lanternaGUI.drawPowerUp(new Position(16, 25));

        lanternaGUI.drawWagon(new Position(15, 8));
        lanternaGUI.drawWagon(new Position(15, 9));
        lanternaGUI.drawWagon(new Position(15, 10));
        lanternaGUI.drawWagon(new Position(15, 11));

        lanternaGUI.putScore(25);
    }
}