package model;

import org.crazytracks.model.Surfer;
import org.crazytracks.model.track_element.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Timer;
import java.util.TimerTask;

public class SurferTest {
    private Surfer surfer;

    @BeforeEach
    public void setUp(){
        this.surfer = new Surfer(Mockito.mock(Position.class));
    }

    @Test
    public void increaseScore(){
        Timer mockTimer = Mockito.mock(Timer.class);
        surfer.setScoreDisplayTimer(mockTimer);
        surfer.increaseScore(5, 2);

        Assertions.assertEquals(1, surfer.getScoreDisplayList().size());

        Mockito.verify(mockTimer).schedule(Mockito.any(TimerTask.class), Mockito.eq(1000L));
    }

}
