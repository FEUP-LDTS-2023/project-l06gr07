package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Menu;
import org.crazytracks.viewer.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuViewerTest {
    private Menu menu;
    private MenuViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        menu = new Menu();
        gui = org.mockito.Mockito.mock(GUI.class);
        viewer = new MenuViewer(menu);
    }

    @Test
    void testDraw() throws IOException {
        viewer.draw(gui);
        org.mockito.Mockito.verify(gui, Mockito.times(1)).drawMenu(menu.getEntries(),0);
    }
}
