package org.crazytracks.model;

import org.junit.jupiter.api.Assertions;
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

    public Position posHelper(int x, int y){
        Position position = Mockito.mock(Position.class);
        Mockito.when(position.getX()).thenReturn(x);
        Mockito.when(position.getY()).thenReturn(y);
        return position;
    }

    @BeforeEach
    public void setUp(){
        this.surfer = new Surfer(posHelper(15, 30));
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
        Coin coin = new CopperCoin(Mockito.mock(Position.class));
        surfer.collectCoin(coin);
        assertEquals(50, surfer.getScore());
    }

    @Test
    void testAlive() {
        surfer.setAlive(false);
        assertFalse(surfer.isAlive());
    }

    @Test
    void testPosition() {
        Position newPosition = posHelper(20, 40);
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
        Position expectedPosition = posHelper(14, 30);
        Position actualPosition = surfer.getLeftPosition();
        assertEquals(expectedPosition.getX(), actualPosition.getX());
        assertEquals(expectedPosition.getY(), actualPosition.getY());
    }

    @Test
    void testGetRightPosition() {
        Position expectedPosition = posHelper(16, 30);
        Position actualPosition = surfer.getRightPosition();
        assertEquals(expectedPosition.getX(), actualPosition.getX());
        assertEquals(expectedPosition.getY(), actualPosition.getY());
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
