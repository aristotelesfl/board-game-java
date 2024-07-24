package rules;

import models.BadPlayer;
import models.LuckPlayer;
import models.NormalPlayer;
import models.Player;
import java.util.random.RandomGenerator;

public class SurpriseRule {
    public static void apply (Player player) {
        System.out.println("Casa 13:\nSurprise MotherFucker... faça o L");
        int jogador = RandomGenerator.getDefault().nextInt(1, 4);
        switch (jogador) {
            case 1 -> {
                player = new NormalPlayer(player.getId(), player.getPosition());
            }
            case 2 -> {
                player = new BadPlayer(player.getId(), player.getPosition());
            }
            case 3 -> {
                player = new LuckPlayer(player.getId(), player.getPosition());
            }
        }
    }
}
