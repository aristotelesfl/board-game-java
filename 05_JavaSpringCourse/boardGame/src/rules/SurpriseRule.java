package rules;

import models.BadPlayer;
import models.LuckPlayer;
import models.NormalPlayer;
import models.Player;
import utils.ColorMap;

import java.util.random.RandomGenerator;

public class SurpriseRule {
    public static Player apply(Player currentPlayer) {
        int id = currentPlayer.getId();
        int position = currentPlayer.getPosition();
        System.out.printf("Casa 13:\n" + ColorMap.colorMap(id, "Player %d ") + "Surprise MotherFucker... faça o L\n", id);
        int jogador = RandomGenerator.getDefault().nextInt(1, 4);

        switch (jogador) {
            case 1 -> {
                System.out.println("Você agora é um Jogador Normal!");
                return new NormalPlayer(id, position);
            }
            case 2 -> {
                System.out.println("Você agora é um Jogador Sortudo!");
                return new LuckPlayer(id, position);
            }
            case 3 -> {
                System.out.println("Você agora é um Jogador Azarado!");
                return new BadPlayer(id, position);
            }
            default -> {
                return currentPlayer;
            }
        }
    }
}
