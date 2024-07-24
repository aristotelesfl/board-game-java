package rules;

import models.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class RestartRule{
    public static void apply(ArrayList<Player> players, Player currentPlayer) {
        System.out.println("Casas 17 e 27:\nAqui você pode escolher alguem para ter um TBT do início do jogo");
        int value;
        while (true) {
            System.out.print("Selecione um jogador para voltar ao inicio: ");
            value = new Scanner(System.in).nextInt();
            if (value != players.indexOf(currentPlayer) &&
                    0 < value && value <= players.size()) {
                players.get(value-1).setPosition(0);
                break;
            } else System.out.println("Jogador Inválido");
        }
    }
}
