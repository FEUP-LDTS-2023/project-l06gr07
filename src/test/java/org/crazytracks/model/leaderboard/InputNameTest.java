package org.crazytracks.model.leaderboard;

import org.crazytracks.gui.GUI;
import org.crazytracks.model.Surfer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class InputNameTest {
    private Surfer surfer;
    private GUI gui;
    private InputName inputName;

    @BeforeEach
    public void setUp() {
        surfer = Mockito.mock(Surfer.class);
        gui = Mockito.mock(GUI.class);
        inputName = new InputName(surfer, gui);
    }

    @Test
    public void setInputText() {
        String newInput = "ThisIsALongInputThatExceedsTheLimit";
        inputName.setInputText(newInput);
        Assertions.assertNotEquals(newInput, inputName.getInputText());
        Assertions.assertEquals("", inputName.getInputText());

        newInput = "TestInput";
        inputName.setInputText(newInput);
        Assertions.assertEquals(newInput, inputName.getInputText());
    }

    @Test
    public void isInputInvalid() {
        Assertions.assertFalse(inputName.isInputInvalid()); // Initially, input should not be considered invalid

        inputName.setInputInvalid(true);
        Assertions.assertTrue(inputName.isInputInvalid());

        inputName.setInputInvalid(false);
        Assertions.assertFalse(inputName.isInputInvalid());
    }

    @Test
    public void getSurfer() {
        Assertions.assertEquals(surfer, inputName.getSurfer());
    }

    @Test
    public void getGUI() {
        Assertions.assertEquals(gui, inputName.getGUI());
    }
}
