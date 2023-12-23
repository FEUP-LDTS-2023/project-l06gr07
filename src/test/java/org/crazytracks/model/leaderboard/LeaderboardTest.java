package org.crazytracks.model.leaderboard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeaderboardTest {
    private Leaderboard leaderboard;
    private List<Player> listOfPlayers;
    private final String leaderboardFilePath = "src/test/resources/Leaderboard.txt";
    public void resetLeaderboard() {
        Path leaderboardFile = Paths.get(this.leaderboardFilePath);
        try {
            Files.deleteIfExists(leaderboardFile);
            Files.createFile(leaderboardFile);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
    @BeforeEach
    public void setUp() {
        resetLeaderboard();
        listOfPlayers = new ArrayList<>();
        listOfPlayers.add(new Player("Alice", 100, 24));
        listOfPlayers.add(new Player("Bob", 150, 24));
        listOfPlayers.add(new Player("Charlie", 120, 24));

        leaderboard = new Leaderboard(listOfPlayers, leaderboardFilePath);
    }

    @Test
    public void getListOfPlayers() {
        List<Player> players = leaderboard.getListOfPlayers();
        Assertions.assertNotNull(players);
        Assertions.assertEquals(listOfPlayers.size(), players.size());
    }

    @Test
    public void insertPlayer() {
        int initialSize = leaderboard.getListOfPlayers().size();
        Player newPlayer = new Player("Dave", 200, 24);
        leaderboard.insertPlayer(newPlayer);

        List<Player> updatedPlayers = leaderboard.getListOfPlayers();
        Assertions.assertNotNull(updatedPlayers);
        Assertions.assertEquals(initialSize + 1, updatedPlayers.size());
        Assertions.assertTrue(updatedPlayers.contains(newPlayer));
    }

    @Test
    public void nextEntry() {
        int expected = 0;
        leaderboard.nextEntry();
        Assertions.assertEquals(expected, leaderboard.getCurrentEntryIndex());
    }

    @Test
    public void previousEntry() {
        int expected = 0;
        leaderboard.previousEntry();
        Assertions.assertEquals(expected, leaderboard.getCurrentEntryIndex());
    }
}
