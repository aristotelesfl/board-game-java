package rules;

import models.Player;
import utils.ColorMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import java.util.ArrayList;
import java.util.Comparator;

public class MagicRule {
    public static void apply(ArrayList<Player> players, Player currentPlayer) {
        System.out.printf("Casas 20 e 35:\n" + ColorMap.colorMap(currentPlayer.getId(), "Player %d ") + "Casas mágicas\n", currentPlayer.getId());

        // Create a copy of the players list
        ArrayList<Player> playersCopy = new ArrayList<>(players);

        // Sort players by position
        playersCopy.sort(Comparator.comparingInt(Player::getPosition));

        // Swap positions with the player at the start
        Player firstPlayer = playersCopy.get(0);
        int aux = firstPlayer.getPosition();

        // Update positions in the original list
        players.get(players.indexOf(firstPlayer)).setPosition(currentPlayer.getPosition());
        currentPlayer.setPosition(aux);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
