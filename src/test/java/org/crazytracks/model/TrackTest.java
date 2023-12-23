package org.crazytracks.model;

import org.crazytracks.gui.sui.soundeffects.CoinCollisionListener;
import org.crazytracks.gui.sui.soundeffects.PowerUpCollisionListener;
import org.crazytracks.gui.sui.soundeffects.WagonCollisionListener;
import org.crazytracks.model.track_element.Position;
import org.crazytracks.model.track_element.PowerUp;
import org.crazytracks.model.track_element.TrackElement;
import org.crazytracks.model.track_element.Wagon;
import org.crazytracks.model.track_element.coin.Coin;
import org.crazytracks.model.track_element.coin.CopperCoin;
import org.crazytracks.model.track_element.coin.GoldCoin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class TrackTest {
    private Track track;
    private CoinCollisionListener coinCollisionListener;
    private WagonCollisionListener wagonCollisionListener;
    private PowerUpCollisionListener powerUpCollisionListener;
    private List<TrackElement> trackElements;

    // track elements helper function to avoid repeating code and improve legibility
    public void trackElementsAddHelper(int x, int y) {
        TrackElement mockTrackElement = new Wagon(new Position(x, y));
        this.trackElements.add(mockTrackElement);
    }

    public void addElements(){
        track.addTrackElement(new CopperCoin(new Position(0, 1)));
        track.addTrackElement(new GoldCoin(new Position(1, 1)));
        track.addTrackElement(new Wagon(new Position(2, 2)));
        track.addTrackElement(new PowerUp(new Position(1, 0)));
        track.addTrackElement(new Wagon(new Position(4, 4)));
    }

    public void addListeners(){
        this.coinCollisionListener = Mockito.mock(CoinCollisionListener.class);
        this.wagonCollisionListener = Mockito.mock(WagonCollisionListener.class);
        this.powerUpCollisionListener = Mockito.mock(PowerUpCollisionListener.class);
        this.track.getCoinCollisionListeners().add(coinCollisionListener);
        this.track.getWagonCollisionListeners().add(wagonCollisionListener);
        this.track.getPowerUpCollisionListeners().add(powerUpCollisionListener);
    }

    @BeforeEach
    public void setUp() {
        this.track = new Track();
        Surfer trackSurfer = new Surfer(new Position(15, 32));
        this.track.setSurfer(trackSurfer);
        addListeners();
    }

    @Test
    public void isEmpty() {
        this.trackElements = new ArrayList<>();track.addTrackElement(new CopperCoin(new Position(0, 1)));
        trackElementsAddHelper(0, 1);
        trackElementsAddHelper(2, 2);
        trackElementsAddHelper(1, 0);
        this.track.setTrackElements(trackElements);

        Assertions.assertTrue(track.isEmpty(new Position(0, 0)));
        Assertions.assertTrue(track.isEmpty(new Position(4, 6)));
        Assertions.assertTrue(track.isEmpty(new Position(4, 5)));
        Assertions.assertTrue(track.isEmpty(new Position(14, 32)));

        Assertions.assertFalse(track.isEmpty(new Position(0, 1)));
        Assertions.assertFalse(track.isEmpty(new Position(2, 2)));
        Assertions.assertFalse(track.isEmpty(new Position(1, 0)));
        Assertions.assertFalse(track.isEmpty(new Position(15, 32)));
    }

    @Test
    public void getTrackElement() {
        addElements();
        TrackElement foundElement = track.getTrackElement(new Position(2, 2));
        Assertions.assertNotNull(foundElement);
        Assertions.assertInstanceOf(Wagon.class, foundElement);
        Assertions.assertEquals(new Position(2, 2), foundElement.getPosition());

        TrackElement notFoundElement = track.getTrackElement(new Position(5, 5));
        Assertions.assertNull(notFoundElement);
    }

    @Test
    public void getWagons() {
        addElements();
        List<Wagon> wagons = track.getWagons();
        Assertions.assertEquals(2, wagons.size());
        for (Wagon wagon : wagons) {
            Assertions.assertInstanceOf(Wagon.class, wagon);
        }
    }

    @Test
    public void getPowerUps() {
        addElements();
        List<PowerUp> powerUps = track.getPowerUps();
        Assertions.assertEquals(1, powerUps.size());
        for (PowerUp powerUp : powerUps) {
            Assertions.assertInstanceOf(PowerUp.class, powerUp);
        }
    }

    @Test
    public void getCoins() {
        addElements();
        List<Coin> coins = track.getCoins();
        Assertions.assertEquals(2, coins.size());
        for (Coin coin : coins) {
            Assertions.assertInstanceOf(Coin.class, coin);
        }
    }

    @Test
    public void moveAllTrackElementsDown() {
        track.addTrackElement(new CopperCoin(new Position(0, 1)));
        track.addTrackElement(new CopperCoin(new Position(2, 2)));

        track.moveAllTrackElementsDown();

        Assertions.assertEquals(track.getTrackElements().get(0).getPosition(), new Position(0, 2));
        Assertions.assertEquals(track.getTrackElements().get(1).getPosition(), new Position(2, 3));
    }

    @Test
    public void getAnimMode(){
        Assertions.assertEquals(track.getAnimMode(), 0);
    }

    @Test
    public void notifyCoinCollisionListeners() {
        track.notifyCoinCollisionListeners();
        Mockito.verify(coinCollisionListener, Mockito.times(1)).onCoinCollision();
    }

    @Test
    public void notifyWagonCollisionListeners() {
        track.notifyWagonCollisionListeners();
        Mockito.verify(wagonCollisionListener, Mockito.times(1)).onWagonCollision();
    }

    @Test
    public void notifyPowerUpCollisionListeners() {
        track.notifyPowerUpCollisionListeners();
        Mockito.verify(powerUpCollisionListener, Mockito.times(1)).onPowerUpCollision();
    }
}
