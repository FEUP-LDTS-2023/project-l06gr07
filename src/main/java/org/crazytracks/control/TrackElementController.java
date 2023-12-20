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
    private long lastPowerUpCreationTime = System.currentTimeMillis();
    private long lastCoinCreationTime = System.currentTimeMillis();
    private final WagonFactory wagonFactory;
    private final PowerUpFactory powerUpFactory;
    private final CoinFactory coinFactory;
    public TrackElementController(Track model) {
        super(model);
        wagonFactory = new WagonFactory();
        powerUpFactory = new PowerUpFactory();
        coinFactory = new CoinFactory();
    }


    public void checkPowerUpCollisions(){
        List<PowerUp> powerUps = getModel().getPowerUps();
        for (PowerUp powerUp : powerUps) {
            if (getModel().getSurfer().getPosition().equals(powerUp.getPosition())) {
                getModel().getSurfer().setMultiplier(getModel().getSurfer().getMultiplier() + 1);
                getModel().getSurfer().setMultiplierSteps(10*60);
                getModel().getTrackElements().remove(powerUp);
                getModel().notifySoundEffectListener("powerup");
            }
        }
    }

    public void checkCoinCollisions(){
        List<Coin> coins = getModel().getCoins();
        for (Coin coin : coins) {
            if (getModel().getSurfer().getPosition().equals(coin.getPosition())) {
                getModel().getSurfer().collectCoin(coin);
                getModel().getTrackElements().remove(coin);
                getModel().notifySoundEffectListener("coin");
            }
        }
    }

    public void checkWagonCollisions(){
        List<Wagon> wagons = getModel().getWagons();
        for (Wagon wagon : wagons) {
            if (getModel().getSurfer().getPosition().equals(wagon.getPosition())) {
                getModel().getSurfer().setAlive(FALSE);
                getModel().notifySoundEffectListener("wagon");
            }
            if (wagon.getPosition().getY() == 40){
                getModel().removeTrackElement(wagon.getPosition());
            }
        }
    }

    public void createWagon(long time){
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastWagonCreationTime >= time) {
            List<Element> wagons1 = wagonFactory.createElement();
            for (Element wagon : wagons1) {
                if (getModel().isEmpty(wagon.getPosition())) {
                    getModel().addTrackElement((TrackElement) wagon);
                }
            }

            List<Element> wagons2 = wagonFactory.createElement();
            for (Element wagon : wagons2) {
                if (getModel().isEmpty(wagon.getPosition())) {
                    getModel().addTrackElement((TrackElement) wagon);
                }
            }

            lastWagonCreationTime = currentTime;
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

    public void moveTrackElements(long time) {
        long currentTime2 = System.currentTimeMillis();
        if (currentTime2 - lastUpdateTime >= time) {
            getModel().moveAllTrackElementsDown();
            checkWagonCollisions();
            checkPowerUpCollisions();
            checkCoinCollisions();
            getModel().getSurfer().nextAnimMode(); // surfer moves synchronised to speed of track
            lastUpdateTime = currentTime2;
        }
    }

    public void checkMultiplierTime(){
        getModel().getSurfer().decreaseMultiplierSteps();
        if (getModel().getSurfer().getMultiplierSteps() == 0){
            getModel().getSurfer().setMultiplier(1);
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        getModel().getSurfer().decreaseMultiplierSteps();
        checkMultiplierTime();

        double currSurferSpeed = getModel().getSurfer().getSurferSpeed() / 12;

        createWagon((long)(1500/currSurferSpeed));
        createPowerUp((long)(10000/currSurferSpeed));
        createCoin((long)(1000/currSurferSpeed));

        moveTrackElements((long)(100/currSurferSpeed));
    }
}
