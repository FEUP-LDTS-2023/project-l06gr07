package org.crazytracks.viewer;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.leaderboard.InputName;
import org.crazytracks.viewer.InputNameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class InputNameViewerTest {
    private InputNameViewer viewer;
    private GUI gui;
    private InputName inputName;

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(GUI.class);
        inputName = Mockito.mock(InputName.class);
        Mockito.when(inputName.getInputText()).thenReturn("Test");
        Mockito.when(inputName.isInputInvalid()).thenReturn(false);
        viewer = new InputNameViewer(inputName);
    }

    @Test
    void testDraw() throws Exception {
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawInputName(Mockito.anyString(), Mockito.anyBoolean());
    }
}
