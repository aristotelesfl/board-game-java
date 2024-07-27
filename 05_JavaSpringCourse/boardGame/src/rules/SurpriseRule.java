package rules;

import models.BadPlayer;
import models.LuckPlayer;
import models.NormalPlayer;
import models.Player;
import utils.ColorMap;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.random.RandomGenerator;

public class SurpriseRule {
    public static Player apply(Player currentPlayer) {
        int id = currentPlayer.getId();
        int position = currentPlayer.getPosition();
        int rounds = currentPlayer.getRounds();
        System.out.printf("Casa 13:\n" + ColorMap.colorMap(id, "Player %d ") + "Casa Surpresa...\n", id);
        int jogador = RandomGenerator.getDefault().nextInt(1, 4);

        switch (jogador) {
            case 1 -> {
                System.out.println("Você agora é um Jogador Normal!");
                return new NormalPlayer(id, position, rounds);
            }
            case 2 -> {
                System.out.println("Você agora é um Jogador Sortudo!");
                return new LuckPlayer(id, position, rounds);
            }
            case 3 -> {
                System.out.println("Você agora é um Jogador Azarado!");
                return new BadPlayer(id, position, rounds);
            }
            default -> {
                return currentPlayer;
            }
        }
    }
}
