package org.crazytracks.model.track_element.coin;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Element;
import org.crazytracks.model.track_element.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CopperCoinDrawStrategyTest {
    private CopperCoinDrawStrategy copperCoinDrawStrategy;
    private Element mockCopperCoin;
    private GUI mockGUI;

    private Position mockPosition;

    @BeforeEach
    public void setUp() {
        copperCoinDrawStrategy = new CopperCoinDrawStrategy();
        mockCopperCoin = Mockito.mock(Element.class);
        mockGUI = Mockito.mock(GUI.class);
        mockPosition = Mockito.mock(Position.class);
    }

    @Test
    public void testDraw() {
        Mockito.when(mockCopperCoin.getPosition()).thenReturn(mockPosition);
        copperCoinDrawStrategy.draw(mockCopperCoin, mockGUI);
        Mockito.verify(mockGUI).drawCopperCoin(mockPosition);
    }
}
