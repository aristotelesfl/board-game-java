package rules;

import models.Player;
import utils.ColorMap;

public class LuckRule {
    public static void apply(Player currentPlayer) {
        System.out.printf("Casas 5, 15 e 30:\n" + ColorMap.colorMap(currentPlayer.getId(), "Player %d ") + "Casas da sorte... Ganhou 3 casas da telecena\n", currentPlayer.getId());
        currentPlayer.luckMove();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
