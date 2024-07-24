package rules;

import models.LuckPlayer;
import models.NormalPlayer;
import models.Player;

public class LuckRule {
    public static void apply(Player currentPlayer) {
        System.out.println("Casas 5, 15 e 30:\nCasas da sorte... ou será que não?");
        if(currentPlayer instanceof LuckPlayer || currentPlayer instanceof NormalPlayer) {
            currentPlayer.move();
        }
    }
}
