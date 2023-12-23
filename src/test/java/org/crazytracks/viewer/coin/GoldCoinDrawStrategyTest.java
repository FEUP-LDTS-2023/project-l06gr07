package org.crazytracks.viewer.coin;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;
import org.crazytracks.model.track_element.Position;
import org.crazytracks.viewer.coin.CopperCoinDrawStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GoldCoinDrawStrategyTest {
    private CopperCoinDrawStrategy goldCoinDrawStrategy;
    private Element mockGoldCoin;
    private GUI mockGUI;

    private Position mockPosition;

    @BeforeEach
    public void setUp() {
        goldCoinDrawStrategy = new CopperCoinDrawStrategy();
        mockGoldCoin = Mockito.mock(Element.class);
        mockGUI = Mockito.mock(GUI.class);
        mockPosition = Mockito.mock(Position.class);
    }

    @Test
    public void testDraw() {
        Mockito.when(mockGoldCoin.getPosition()).thenReturn(mockPosition);
        goldCoinDrawStrategy.draw(mockGoldCoin, mockGUI);
        Mockito.verify(mockGUI).drawCopperCoin(mockPosition);
    }
}
