package org.crazytracks.model;

import org.crazytracks.model.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    private Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu();
    }

    @Test
    void testMenu() {
        assertNotNull(menu);
    }

    @Test
    void testGetEntries() {
        assertEquals(Arrays.asList("Start", "Leaderboard", "Exit"), menu.getEntries());
    }

    @Test
    void testGetCurrentEntry() {
        assertEquals("Start", menu.getCurrentEntry());
    }

    @Test
    void testNextEntry() {
        menu.nextEntry();
        assertEquals("Leaderboard", menu.getCurrentEntry());
    }

    @Test
    void testPreviousEntry() {
        menu.previousEntry();
        assertEquals("Exit", menu.getCurrentEntry());
    }

    @Test
    void testGetEntry() {
        assertEquals("Start", menu.getEntry(0));
        assertEquals("Leaderboard", menu.getEntry(1));
        assertEquals("Exit", menu.getEntry(2));
    }

    @Test
    void testGetCurrentEntryIndex() {
        assertEquals(0, menu.getCurrentEntryIndex());
    }

    @Test
    void testIsSelected() {
        assertTrue(menu.IsSelected(0));
        assertFalse(menu.IsSelected(1));
        assertFalse(menu.IsSelected(2));
    }

    @Test
    void testIsSelectedStart() {
        assertTrue(menu.isSelectedStart());
    }

    @Test
    void testIsSelectedLeaderboard() {
        assertFalse(menu.isSelectedLeaderboard());
    }

    @Test
    void testIsSelectedExit() {
        assertFalse(menu.isSelectedExit());
    }
}
