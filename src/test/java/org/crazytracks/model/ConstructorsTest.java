package org.crazytracks.model;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Menu;
import org.crazytracks.model.Surfer;
import org.crazytracks.model.Track;
import org.crazytracks.model.leaderboard.InputName;
import org.crazytracks.model.leaderboard.Player;
import org.crazytracks.model.track_element.*;
import org.crazytracks.model.track_element.coin.*;
import org.crazytracks.states.GameState;
import org.crazytracks.states.MenuState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ConstructorsTest {

    // some useful helper functions to avoid repeating code and save time
    public Position posHelper(int x, int y){
        Position position = Mockito.mock(Position.class);
        Mockito.when(position.getX()).thenReturn(x);
        Mockito.when(position.getY()).thenReturn(y);
        return position;
    }

    public Surfer surferHelper(int x, int y){
        Surfer surfer = Mockito.mock(Surfer.class);
        Position position = posHelper(x, y);
        Mockito.when(surfer.getPosition()).thenReturn(position);
        Mockito.when(surfer.getScore()).thenReturn(0);
        return surfer;
    }

    @Test
    public void testPlayerConstructor(){
        int savedScore = 100;
        int endSpeed = 24;
        Player player = new Player("Surfer123", 100, 24);
        Assertions.assertEquals("Surfer123", player.getName());
        Assertions.assertEquals(savedScore, player.getSavedScore());
        Assertions.assertEquals(endSpeed, player.getEndSpeed());
    }

    @Test
    public void testInputTextConstructor(){
        InputName inputName = new InputName(Mockito.mock(Surfer.class), Mockito.mock(GUI.class));
        Assertions.assertEquals("", inputName.getInputText());
        Assertions.assertFalse(inputName.isInputInvalid());
    }

    @Test
    public void testCoinConstructor() {
        DrawStrategy mockDrawStrategy = Mockito.mock(DrawStrategy.class);
        int coinValue = 123;
        class TestCoin extends Coin{
            public TestCoin(Position position, int coinValue, DrawStrategy drawStrategy) {
                super(position, coinValue, drawStrategy);
            }
        }

        Coin coin = new TestCoin(posHelper(0, 1), coinValue, mockDrawStrategy);
        Assertions.assertEquals(0, coin.getPosition().getX());
        Assertions.assertEquals(1, coin.getPosition().getY());
        Assertions.assertEquals(coinValue, coin.getCoinValue());
        Assertions.assertEquals(coinValue, coin.getCoinValue());
        Assertions.assertEquals(mockDrawStrategy, coin.getDrawStrategy());
    }

    @Test
    public void CopperCoinConstructors() {
        Coin coin = new CopperCoin(posHelper(0, 1));

        Assertions.assertEquals(0, coin.getPosition().getX());
        Assertions.assertEquals(1, coin.getPosition().getY());
        Assertions.assertInstanceOf(CopperCoinDrawStrategy.class, coin.getDrawStrategy());
    }

    @Test
    public void GoldCoinConstructors() {
        Coin coin = new GoldCoin(posHelper(0, 1));

        Assertions.assertEquals(0, coin.getPosition().getX());
        Assertions.assertEquals(1, coin.getPosition().getY());
        Assertions.assertInstanceOf(GoldCoinDrawStrategy.class, coin.getDrawStrategy());
    }

    @Test
    public void testPowerUpConstructor() {
        PowerUp powerUp = new PowerUp(posHelper(0, 1));
        Assertions.assertEquals(0, powerUp.getPosition().getX());
        Assertions.assertEquals(1, powerUp.getPosition().getY());
    }

    @Test
    public void testWagonConstructor() {
        Wagon wagon = new Wagon(posHelper(0, 1));
        Assertions.assertEquals(0, wagon.getPosition().getX());
        Assertions.assertEquals(1, wagon.getPosition().getY());
    }

    @Test
    public void testSurferConstructor() {
        Surfer surfer = surferHelper(0, 1);
        Assertions.assertEquals(0, surfer.getPosition().getX());
        Assertions.assertEquals(1, surfer.getPosition().getY());
        Assertions.assertEquals(0, surfer.getScore());
    }

    @Test
    public void GameStateConstructor() {
        Track track = new Track();
        track.setSurfer(new Surfer(posHelper(0, 1)));
        GameState gameState = new GameState(track);
        Assertions.assertEquals(track, gameState.getModel());
    }

    @Test
    public void MenuStateConstructor() {
        Menu menu = new Menu();
        MenuState menuState = new MenuState(menu);
        Assertions.assertEquals(menu, menuState.getModel());
    }

    @Test
    public void TrackConstructor() {
        Track track = new Track();
        Surfer surfer = surferHelper(0, 1);
        track.setSurfer(surfer);
        List<TrackElement> trackElements = new ArrayList<>();
        track.setTrackElements(trackElements);
        Assertions.assertEquals(0, track.getSurfer().getPosition().getX());
        Assertions.assertEquals(1, track.getSurfer().getPosition().getY());
        Assertions.assertEquals(0, track.getSurfer().getScore());
        Assertions.assertEquals(0, track.getTrackElements().size());
    }
}
