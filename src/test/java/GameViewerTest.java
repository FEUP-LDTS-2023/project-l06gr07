import com.googlecode.lanterna.screen.Screen;
import org.crazytracks.gui.LanternaGUI;
import org.crazytracks.gui.PositionAdapter;
import org.crazytracks.model.Position;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;

public class GameViewerTest {
    private LanternaGUI lanternaGUI;
    private Screen screen;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final int xTrackOffset = 15;

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

    public Position posAdapt(Position position){
        PositionAdapter positionAdapter = new PositionAdapter(this.xTrackOffset-1, lanternaGUI.getTerminalHeight());
        return positionAdapter.adaptPosition(position);
    }

    @Test
    public void elementDrawerTest() {
        lanternaGUI.drawSurfer(posAdapt(new Position(1, 3)));

        lanternaGUI.drawPowerUp(posAdapt(new Position(1, 25)));
        lanternaGUI.drawPowerUp(posAdapt(new Position(0, 13)));

        lanternaGUI.drawCoin(posAdapt(new Position(2, 5)));
        lanternaGUI.drawCoin(posAdapt(new Position(1, 30)));
        lanternaGUI.drawCoin(posAdapt(new Position(2, 32)));
        lanternaGUI.drawCoin(posAdapt(new Position(0, 20)));

        lanternaGUI.drawWagon(posAdapt(new Position(0, 8)));
        lanternaGUI.drawWagon(posAdapt(new Position(0, 9)));
        lanternaGUI.drawWagon(posAdapt(new Position(0, 10)));
        lanternaGUI.drawWagon(posAdapt(new Position(0, 11)));

        lanternaGUI.drawWagon(posAdapt(new Position(1, 14)));
        lanternaGUI.drawWagon(posAdapt(new Position(1, 15)));
        lanternaGUI.drawWagon(posAdapt(new Position(1, 16)));

        lanternaGUI.drawWagon(posAdapt(new Position(0, 22)));
        lanternaGUI.drawWagon(posAdapt(new Position(0, 23)));

        lanternaGUI.drawWagon(posAdapt(new Position(2, 21)));
        lanternaGUI.drawWagon(posAdapt(new Position(2, 22)));
        lanternaGUI.drawWagon(posAdapt(new Position(2, 23)));

        lanternaGUI.drawWagon(posAdapt(new Position(2, 31)));
        lanternaGUI.drawWagon(posAdapt(new Position(2, 32)));
        lanternaGUI.drawWagon(posAdapt(new Position(2, 33)));
        lanternaGUI.drawWagon(posAdapt(new Position(2, 34)));
        lanternaGUI.drawWagon(posAdapt(new Position(2, 35)));
        lanternaGUI.drawWagon(posAdapt(new Position(2, 36)));
        lanternaGUI.drawWagon(posAdapt(new Position(2, 37)));
        lanternaGUI.drawWagon(posAdapt(new Position(2, 38)));

        lanternaGUI.putScore(25);
        lanternaGUI.putMultiplier(3);
    }
}