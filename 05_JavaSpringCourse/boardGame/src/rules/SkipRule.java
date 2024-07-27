package rules;

import models.Player;
import utils.ColorMap;

public class SkipRule {
    public static void apply (Player currentPlayer) {
        System.out.printf("Casas 10, 25 e 38:\n" + ColorMap.colorMap(currentPlayer.getId(), "Player %d ") + "Foi namorar, perdeu o lugar!\nPerca a vez\n", currentPlayer.getId());
        currentPlayer.setCanPlay(false);
        currentPlayer.addRounds();
    }
}
