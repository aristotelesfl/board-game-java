package models;

import rules.*;
import utils.ColorMap;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Board {

    public static void generateBoard(ArrayList<Player> listOfPlayers) {
        for (int i = 0; i < 40; i++) {
            int currentPosition = i;
            AtomicBoolean isOccuped = new AtomicBoolean(false);
            listOfPlayers.forEach(player -> {
                if (player.getPosition() == currentPosition) {
                    System.out.print(ColorMap.colorMap(
                            player.getId(), "(  "+player.getId()+"  )"));
                    isOccuped.set(true);
                }
                specialCases(listOfPlayers, player);
            });
            if (!isOccuped.get()) System.out.printf("(  %d  )", i);
            if ((i+1)%10==0) System.out.println();
            else System.out.print(" | ");
        }
    }

    private static void specialCases(ArrayList listOfPlayers, Player currentPlayer) {
        switch (currentPlayer.getPosition()) {
//            case 10, 25, 28 -> SkipRule.apply(currentPlayer);
//            case 13 -> SurpriseRule.apply(currentPlayer);
            case 5, 15, 30 -> LuckRule.apply(currentPlayer);
            case 17, 27 -> RestartRule.apply(listOfPlayers, currentPlayer);
            case 20, 35 -> MagicRule.apply(listOfPlayers, currentPlayer);
        }
    }
}
