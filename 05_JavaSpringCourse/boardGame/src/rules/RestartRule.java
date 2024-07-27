package rules;

import models.Player;
import utils.ColorMap;

import java.util.ArrayList;
import java.util.Scanner;

public class RestartRule{
    public static void apply(ArrayList<Player> players, Player currentPlayer) {
        System.out.printf("Casas 17 e 27:\n" + ColorMap.colorMap(currentPlayer.getId(), "Player %d ") + "Aqui você pode escolher alguem para ter um TBT do início do jogo\n", currentPlayer.getId());
        int value;
        while (true) {
            System.out.print("Selecione um jogador para voltar ao inicio: ");
            value = new Scanner(System.in).nextInt();
            if (value != players.indexOf(currentPlayer)+1 &&
                    0 < value && value <= players.size()) {
                players.get(value-1).setPosition();
                break;
            } else System.out.println("Jogador Inválido");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
