import Game.GameMode;
import Game.NewGame;
import models.BadPlayer;
import models.Board;
import models.NormalPlayer;
import models.Player;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.random.RandomGenerator;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GameMode mode = new NewGame();

        while (true) {
            System.out.println("""
                Selecione a quantidade de jogadores:
                1 - 2 Jogadores
                2 - 3 Jogadores
                3 - 4 Jogadores
                4 - 5 Jogadores
                5 - 6 Jogadores""");

            int choice = input.nextInt();

            switch (choice) {
                case 1 -> {
                    mode.playGame(2);
                    input.close();
                }
                case 2 -> {
                    mode.playGame(3);
                    input.close();
                }
                case 3 -> {
                    mode.playGame(4);
                    input.close();
                }
                case 4 -> {
                    mode.playGame(5);
                    input.close();
                }
                case 5 -> {
                    mode.playGame(6);
                    input.close();
                }
                default -> System.out.println("Opção Inválida!");
            }
        }
    }
}
