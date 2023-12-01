package org.crazytracks.gui;

import com.googlecode.lanterna.TextColor;
import org.crazytracks.model.Position;
import org.crazytracks.model.TrackElement;
import org.crazytracks.model.Wagon;

import java.util.ArrayList;
import java.util.List;

public class TrackAnimation {
    private final int xMargin;
    private final TextColor borderColor;
    private final GUI gui;
    private int animMode;
    private int trackHeight;
    private List<TrackElement> trackElements;

    public TrackAnimation(GUI gui, int xMargin, TextColor borderColor, int trackHeight){
        this.gui = gui;
        this.xMargin = xMargin;
        this.trackHeight = trackHeight;
        this.animMode = 0;
        this.borderColor = borderColor;
        this.trackElements = loadTrackList();
        initAnimation();
        for (int i = 0; i < 10; i++){
            step();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void step(){
        this.animMode = (this.animMode + 1)%2;
        decrementYPos();
        gui.drawTrack(xMargin, animMode, borderColor);
        drawTrackElements();
    }

    private void initAnimation(){
        gui.drawTrack(xMargin, animMode, borderColor);
    }

    private List<TrackElement> loadTrackList(){
        List<TrackElement> loadedTrack = new ArrayList<>();

        loadedTrack.add(new Wagon(new Position(2, 25)));
        loadedTrack.add(new Wagon(new Position(2, 26)));
        loadedTrack.add(new Wagon(new Position(2, 27)));
        loadedTrack.add(new Wagon(new Position(2, 28)));

        return loadedTrack;
    }
    private void decrementYPos(){
        for (int i = 0; i < trackElements.size(); i++){
            TrackElement te = trackElements.get(i);
            if (te.getPosition().getY() > 0){
                te.setPosition(new Position(te.getPosition().getX(), te.getPosition().getY()-1));
            } else {
                trackElements.remove(i);
            }
        }
    }
    private void drawTrackElements(){
        for (TrackElement te : trackElements){
            PositionAdapter positionAdapter = new PositionAdapter(this.xMargin, this.trackHeight-1);
            Position adaptedPosition = positionAdapter.adaptPosition(te.getPosition());
            gui.drawWagon(adaptedPosition);
        }
    }

}
