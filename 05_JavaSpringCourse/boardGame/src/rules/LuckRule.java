package rules;

import models.Player;

public class LuckRule {
    public static void apply(Player currentPlayer) {
        currentPlayer.move();
    }
}
