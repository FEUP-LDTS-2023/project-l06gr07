package org.crazytracks.model.leaderboard;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;


import static java.nio.charset.StandardCharsets.UTF_8;

public class LeaderboardLoader {
    private String filepath;
    public LeaderboardLoader(String filepath){
        this.filepath = filepath; // for future implementation of persistent data
    }

    public void save(Leaderboard leaderboard){
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filepath), UTF_8)){
            List<Player> listPlayers = leaderboard.getListOfPlayers();
            for (Player player : listPlayers){
                writer.write(player.getName());
                writer.write("\t");
                writer.write(String.valueOf(player.getSavedScore()));
                writer.write("\t");
                writer.write(String.valueOf(player.getEndSpeed()));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Player> loadList(){
        System.out.println("loadingList");
        List<Player> newListPlayers = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filepath), UTF_8)){
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> attrs = Splitter.on(Pattern.compile("\t")).splitToList(line);
                if (attrs.size() == 3){
                    Player currPlayer = new Player(
                            attrs.get(0),
                            Integer.parseInt(attrs.get(1)),
                            Integer.parseInt(attrs.get(2))
                    );
                    newListPlayers.add(currPlayer);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        newListPlayers.sort(Comparator.comparingInt(Player::getSavedScore).reversed());
        return newListPlayers;
    }
}
