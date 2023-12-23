package org.crazytracks.model.leaderboard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private Player player;

    @BeforeEach
    public void setUp(){
        this.player = new Player("Surfer123", 100, 24);
    }

    @Test
    public void getSavedScore() {
        Assertions.assertEquals(100, player.getSavedScore());
    }

    @Test
    public void getEndSpeed() {
        Assertions.assertEquals(24, player.getEndSpeed());
    }

    @Test
    public void getName() {
        Assertions.assertEquals("Surfer123", player.getName());
    }
}
