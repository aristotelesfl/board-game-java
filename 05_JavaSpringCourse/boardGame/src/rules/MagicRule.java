package rules;

import models.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class MagicRule {
    public static void apply(ArrayList<Player> players, Player currentPlayer) {
        System.out.println("Casas 20 e 35:\nCasas mágicas");
        System.out.println();
        players.sort((p1, p2) -> Integer.compare(p1.getPosition(), p2.getPosition()));
        if (players.indexOf(currentPlayer) != 0) {
            int aux = players.get(0).getPosition();
            players.get(0).setPosition(currentPlayer.getPosition());
            currentPlayer.setPosition(aux);
        }
    }
}
