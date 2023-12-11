package org.crazytracks.control;

import org.crazytracks.Game;
import org.crazytracks.gui.GUI;
import org.crazytracks.model.*;
import org.crazytracks.model.factory.CoinFactory;
import org.crazytracks.model.factory.PowerUpFactory;
import org.crazytracks.model.factory.WagonFactory;

import java.io.IOException;
import java.util.List;

import static java.lang.Boolean.FALSE;

public class TrackElementController extends GameController{
    private long lastUpdateTime = System.currentTimeMillis();
    private long lastWagonCreationTime = System.currentTimeMillis();
    private long lastWagonCreationTime2 = System.currentTimeMillis();
    private long lastPowerUpCreationTime = System.currentTimeMillis();
    private long lastCoinCreationTime = System.currentTimeMillis();
    private WagonFactory wagonFactory;
    private WagonFactory wagonFactory2;
    private PowerUpFactory powerUpFactory;
    private CoinFactory coinFactory;
    public TrackElementController(Track model) {
        super(model);
        wagonFactory = new WagonFactory();
        wagonFactory2 = new WagonFactory();
        powerUpFactory = new PowerUpFactory();
        coinFactory = new CoinFactory();
    }


    public void checkPowerUpCollisions(){
        List<PowerUp> powerUps = getModel().getPowerUps();
        for (PowerUp powerUp : powerUps) {
            if (getModel().getSurfer().getPosition().equals(powerUp.getPosition())) {
                getModel().getSurfer().setMultiplier(2);
            }
        }
    }

    public void checkCoinCollisions(){
        List<Coin> coins = getModel().getCoins();
        for (Coin coin : coins) {
            if (getModel().getSurfer().getPosition().equals(coin.getPosition())) {
                getModel().getSurfer().increaseScore(100, getModel().getSurfer().getMultiplier());
            }
        }
    }

    public void checkWagonCollisions(){
        List<Wagon> wagons = getModel().getWagons();
        for (Wagon wagon : wagons) {
            System.out.println("Wagon:" + wagon.getPosition().getX() + "," + wagon.getPosition().getY());
            System.out.println("Surfer:" + getModel().getSurfer().getPosition().getX() + "," + getModel().getSurfer().getPosition().getY());
            if (getModel().getSurfer().getPosition().equals(wagon.getPosition())) {
                getModel().getSurfer().setAlive(FALSE);
            }
            if (wagon.getPosition().getY() == 40){
                getModel().removeTrackElement(wagon.getPosition());
            }
        }
    }

    public void createWagon(long time){
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastWagonCreationTime >= time) {
            List<Element> wagons = wagonFactory.createElement();
            for (Element wagon : wagons) {
                if (getModel().isEmpty(wagon.getPosition())) {
                    getModel().addTrackElement((TrackElement) wagon);
                }
            }
            lastWagonCreationTime = currentTime;
        }
    }

    public void createWagon2(long time){
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastWagonCreationTime2 >= time) {
            List<Element> wagons = wagonFactory2.createElement();
            for (Element wagon : wagons) {
                if (getModel().isEmpty(wagon.getPosition())) {
                    getModel().addTrackElement((TrackElement) wagon);
                }
            }
            lastWagonCreationTime2 = currentTime;
        }
    }

    public void createPowerUp(long time){
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastPowerUpCreationTime >= time) {
            List<Element> powerUps = powerUpFactory.createElement();
            for (Element powerUp : powerUps) {
                if (getModel().isEmpty(powerUp.getPosition())) {
                    getModel().addTrackElement((TrackElement) powerUp);
                }
            }
            lastPowerUpCreationTime = currentTime;
        }
    }

    public void moveTrackElements(long time) {
        long currentTime2 = System.currentTimeMillis();
        if (currentTime2 - lastUpdateTime >= time) {
            getModel().moveAllTrackElementsDown();
            checkWagonCollisions();
            checkPowerUpCollisions();
            checkCoinCollisions();
            lastUpdateTime = currentTime2;
        }
    }
    public void createCoin(long time){
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastCoinCreationTime >= time) {
            List<Element> coins = coinFactory.createElement();
            for (Element coin : coins) {
                if (getModel().isEmpty(coin.getPosition())) {
                    getModel().addTrackElement((TrackElement) coin);
                }
            }
            lastCoinCreationTime = currentTime;
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        createWagon(1300);
        createWagon2(1300);
        createPowerUp(1300);
        createCoin(500);
        moveTrackElements(100);
    }
}
