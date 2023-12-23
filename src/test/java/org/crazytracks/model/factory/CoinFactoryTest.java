package org.crazytracks.model.factory;

import org.crazytracks.model.Element;
import org.crazytracks.model.factory.CoinFactory;
import org.crazytracks.model.track_element.coin.CopperCoin;
import org.crazytracks.model.track_element.coin.GoldCoin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoinFactoryTest {
    private CoinFactory coinFactory;

    @BeforeEach
    void setUp() {
        coinFactory = new CoinFactory();
    }

    @Test
    void createElement() {
        List<Element> coins = coinFactory.createElement();

        assertFalse(coins.isEmpty());

        Element coin = coins.get(0);
        assertTrue(coin instanceof CopperCoin || coin instanceof GoldCoin);
    }
}