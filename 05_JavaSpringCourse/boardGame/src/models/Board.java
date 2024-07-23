package models;

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
            });
            if (!isOccuped.get()) System.out.printf("(  %d  )", i);
            if ((i+1)%10==0) System.out.println();
            else System.out.print(" | ");
        }
    }
}
