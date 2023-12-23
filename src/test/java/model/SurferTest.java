package model;

import org.mockito.Mockito;

import java.util.Timer;
import java.util.TimerTask;
import org.crazytracks.model.Animation;
import org.crazytracks.model.Surfer;
import org.crazytracks.model.track_element.Position;
import org.crazytracks.model.track_element.coin.Coin;
import org.crazytracks.model.track_element.coin.CopperCoin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testMultiplier() {
        surfer.setMultiplier(2);
        assertEquals(2, surfer.getMultiplier());
    }

    @Test
    void testCollectCoin() {
        Coin coin = new CopperCoin(new Position(15, 30));
        surfer.collectCoin(coin);
        // Assuming Surfer has a getCoins method
        assertEquals(50, surfer.getScore());
    }

    @Test
    void testAlive() {
        surfer.setAlive(false);
        assertFalse(surfer.isAlive());
    }

    @Test
    void testPosition() {
        Position newPosition = new Position(20, 40);
        surfer.setPosition(newPosition);
        assertEquals(newPosition, surfer.getPosition());
    }

    @Test
    void testSurferSpeed() {
        surfer.setSurferSpeed(10);
        assertEquals(10, surfer.getSurferSpeed());
    }

    @Test
    void testAnimation() {
        Animation anim = new Animation(4);
        surfer.setAnim(anim);
        assertEquals(anim, surfer.getAnim());
    }

    @Test
    void testGetLeftPosition() {
        assertEquals(new Position(14, 30), surfer.getLeftPosition());
    }

    @Test
    void testGetRightPosition() {
        assertEquals(new Position(16, 30), surfer.getRightPosition());
    }

    @Test
    void testGetCurrentLane() {
        assertEquals(1, surfer.getCurrentLane());
    }

    @Test
    void testGetScore() {
        assertEquals(0, surfer.getScore());
    }

    @Test
    void testGetMultiplier() {
        assertEquals(1, surfer.getMultiplier());
    }

    @Test
    void testGetMultiplierSteps() {
        assertEquals(0, surfer.getMultiplierSteps());
    }
}
