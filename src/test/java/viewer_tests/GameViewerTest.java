package viewer_tests;

import org.crazytracks.gui.GUI;
import org.crazytracks.gui.LanternaGUI;
import org.crazytracks.model.*;
import org.crazytracks.model.Surfer;
import org.crazytracks.model.track_element.Position;
import org.crazytracks.model.track_element.PowerUp;
import org.crazytracks.model.track_element.TrackElement;
import org.crazytracks.model.track_element.Wagon;
import org.crazytracks.viewer.GameViewer;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static java.lang.Boolean.TRUE;

public class GameViewerTest {
    @Test
    public void GameViewerTest() throws IOException, URISyntaxException, FontFormatException, InterruptedException {
        Track track = new Track();
        track.setSurfer(new Surfer(new Position(15, 30)));
        track.addTrackElement(new Wagon(new Position(15, 7)));
        track.addTrackElement(new Wagon(new Position(15, 8)));
        track.addTrackElement(new Wagon(new Position(15, 9)));
        track.addTrackElement(new Wagon(new Position(15, 10)));
        track.addTrackElement(new PowerUp(new Position(15, 25)));
        GUI gui = new LanternaGUI(30, 40);
        GameViewer viewer = new GameViewer(track);
        int i = 0;
        int FPS = 60;
        int frameTime = 1000 / FPS;
        while (true){
            if (i==100){
                track.addTrackElement(new Wagon(new Position(15, 7)));
                track.addTrackElement(new Wagon(new Position(15, 8)));
                track.addTrackElement(new Wagon(new Position(15, 9)));
                track.addTrackElement(new Wagon(new Position(15, 10)));
                track.addTrackElement(new PowerUp(new Position(15, 25)));
                track.getSurfer().setMultiplier(2);
                i=0;
            }
            for (TrackElement element : track.getTrackElements()) {
                if (element instanceof Wagon) {
                    ((Wagon) element).setPosition(new Position(((Wagon) element).getPosition().getX(), ((Wagon) element).getPosition().getY()+1));
                }
                if (track.getSurfer().getScore()<1000) {
                    track.getSurfer().increaseScore(1,track.getSurfer().getMultiplier());
                }
            }
            long startTime = System.currentTimeMillis();
            viewer.draw(gui);
            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;
            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
            i++;
        }
    }
}