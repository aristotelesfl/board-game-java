package models;

import utils.PlayDice;

import java.util.Arrays;

public class LuckPlayer extends Player {

    public LuckPlayer() {
        super();
    }

    public LuckPlayer(int id, int position) {
        super(id, position);
    }

    @Override
    public void playDice(int playerID) {
        int[] value = Arrays.stream(PlayDice.go(playerID)).toArray();
        int sum = value[0] + value[1];

        System.out.printf("O Player %d esta lançando os dados...\n", playerID);
        do {
            while (sum <= 7) {
                value = Arrays.stream(PlayDice.go(playerID)).toArray();
                sum = value[0] + value[1];
            }
            System.out.println("Dados " + value[0] + " e " + value[1] + "=" + sum);
            if (value[0] == value[1]) {
                System.out.println("Números iguais nos dados, jogando novamente... ");
                value = Arrays.stream(PlayDice.go(playerID)).toArray();
                int sum2 = value[0] + value[1];
                while (sum2 <= 7) {
                    value = Arrays.stream(PlayDice.go(playerID)).toArray();
                    sum2 = value[0] + value[1];
                }
                sum += sum2;
                System.out.println("Dados " + value[0] + " e " + value[1] + "=" + sum2 + " " + sum);
            }
        } while (value[0] == value[1]);
        this.position += sum;

    }

}

