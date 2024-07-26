package rules;

import models.BadPlayer;
import models.LuckPlayer;
import models.NormalPlayer;
import models.Player;
import utils.ColorMap;

import java.util.random.RandomGenerator;

public class SurpriseRule {
    public static Player apply(Player currentPlayer) {
        Player newPlayer;
        int id = currentPlayer.getId();
        int position = currentPlayer.getPosition();
        System.out.printf("Casa 13:\n" + ColorMap.colorMap(id, "Player %d ") + "Surprise MotherFucker... faça o L\n", id);
        int jogador = RandomGenerator.getDefault().nextInt(1, 4);

        switch (jogador) {
            case 1 -> {
                newPlayer = new NormalPlayer(id, position);
                System.out.println("Você agora é um Jogador Normal!");
            }
            case 2 -> {
                newPlayer = new LuckPlayer(id, position);
                System.out.println("Você agora é um Jogador Sortudo!");
            }
            case 3 -> {
                newPlayer = new BadPlayer(id, position);
                System.out.println("Você agora é um Jogador Azarado!");
            }
            default -> {
                newPlayer = currentPlayer;
                System.out.println("Nenhuma mudança ocorreu.");
            }
        }

        return newPlayer;
    }
}