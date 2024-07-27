package rules;

import models.Player;
import utils.ColorMap;

import java.util.ArrayList;
import java.util.Comparator;

public class MagicRule {
    public static void apply(ArrayList<Player> players, Player currentPlayer) {
        System.out.printf("Casas 20 e 35:\n" + ColorMap.colorMap(currentPlayer.getId(), "Player %d ") + "Casas mágicas\nTroque de lugar com o último jogador\n", currentPlayer.getId());

        ArrayList<Player> playersCopy = new ArrayList<>(players);

        playersCopy.sort(Comparator.comparingInt(Player::getPosition));

        Player firstPlayer = playersCopy.getFirst();

        players.get(players.indexOf(firstPlayer)).setPosition();
        currentPlayer.setPosition();

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}
