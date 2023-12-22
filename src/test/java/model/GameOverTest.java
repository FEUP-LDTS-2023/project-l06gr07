package model;

import org.crazytracks.model.GameOver;
import org.crazytracks.model.leaderboard.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GameOverTest {
    @Test
    public void nextEntry(){
        GameOver gameOver = new GameOver(Mockito.mock(Player.class));
        String expected1 = gameOver.getEntries().get(0);
        String expected2 = gameOver.getEntries().get(1);
        String expected3 = gameOver.getEntries().get(0);

        Assertions.assertEquals(gameOver.getCurrentEntry(), expected1);

        gameOver.nextEntry();
        Assertions.assertEquals(gameOver.getCurrentEntry(), expected2);

        gameOver.nextEntry();
        Assertions.assertEquals(gameOver.getCurrentEntry(), expected3);
    }

    @Test
    public void previousEntry(){
        GameOver gameOver = new GameOver(Mockito.mock(Player.class));
        String expected1 = gameOver.getEntries().get(0);
        String expected2 = gameOver.getEntries().get(1);
        String expected3 = gameOver.getEntries().get(0);

        Assertions.assertEquals(gameOver.getCurrentEntry(), expected1);

        gameOver.previousEntry();
        Assertions.assertEquals(gameOver.getCurrentEntry(), expected2);

        gameOver.previousEntry();
        Assertions.assertEquals(gameOver.getCurrentEntry(), expected3);
    }
}
