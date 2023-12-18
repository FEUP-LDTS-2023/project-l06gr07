package org.crazytracks.leaderboard;

import java.io.*;
import java.util.*;

public class LeaderboardLoader {
    private String filepath;
    public LeaderboardLoader(String filepath){
        this.filepath = filepath; // for future implementation of persistent data
    }

    public void save(Leaderboard leaderboard){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))){
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
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attrs = line.split("\t");
                if (attrs.length == 3){
                    Player currPlayer = new Player(
                            attrs[0],
                            Integer.parseInt(attrs[1]),
                            Integer.parseInt(attrs[2])
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
