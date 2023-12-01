import com.googlecode.lanterna.screen.Screen;
import org.crazytracks.gui.LanternaGUI;
import org.crazytracks.model.Position;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;

public class ViewerTest {
    private LanternaGUI lanternaGUI;
    private Screen screen;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        try {
            lanternaGUI = new LanternaGUI(30, 40);
            lanternaGUI.initGameGUI();
        } catch (IOException | URISyntaxException | FontFormatException e) {
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
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void elementDrawerTest() {
        lanternaGUI.drawSurfer(new Position(1, 3));

        lanternaGUI.drawPowerUp(new Position(1, 25));
        lanternaGUI.drawPowerUp(new Position(0, 13));

        lanternaGUI.drawCoin(new Position(2, 5));
        lanternaGUI.drawCoin(new Position(1, 30));
        lanternaGUI.drawCoin(new Position(2, 32));
        lanternaGUI.drawCoin(new Position(0, 20));

        lanternaGUI.drawWagon(new Position(0, 8));
        lanternaGUI.drawWagon(new Position(0, 9));
        lanternaGUI.drawWagon(new Position(0, 10));
        lanternaGUI.drawWagon(new Position(0, 11));

        lanternaGUI.drawWagon(new Position(1, 14));
        lanternaGUI.drawWagon(new Position(1, 15));
        lanternaGUI.drawWagon(new Position(1, 16));

        lanternaGUI.drawWagon(new Position(0, 22));
        lanternaGUI.drawWagon(new Position(0, 23));

        lanternaGUI.drawWagon(new Position(2, 21));
        lanternaGUI.drawWagon(new Position(2, 22));
        lanternaGUI.drawWagon(new Position(2, 23));

        lanternaGUI.drawWagon(new Position(2, 31));
        lanternaGUI.drawWagon(new Position(2, 32));
        lanternaGUI.drawWagon(new Position(2, 33));
        lanternaGUI.drawWagon(new Position(2, 34));
        lanternaGUI.drawWagon(new Position(2, 35));
        lanternaGUI.drawWagon(new Position(2, 36));
        lanternaGUI.drawWagon(new Position(2, 37));
        lanternaGUI.drawWagon(new Position(2, 38));

        lanternaGUI.putScore(25);
        lanternaGUI.putMultiplier(25);
    }
}