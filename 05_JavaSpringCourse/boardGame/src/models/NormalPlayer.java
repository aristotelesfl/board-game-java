package models;

import utils.PlayDice;
import java.util.Arrays;

public class NormalPlayer extends Player {
    public NormalPlayer(){
        super();
    }
    public NormalPlayer(int id, int position) {
        super(id, position);
    }

    @Override

    public void playDice(int playerID) {
        this.position += Arrays.stream(PlayDice.go(playerID)).sum();
        int []value = Arrays.stream(PlayDice.go(playerID)).toArray();

        System.out.printf("O Player %d esta lançando os dados...\n", playerID);
        do {
            int sum = value[0] + value[1];

            System.out.println("Dados " + value[0] + " e " + value[1]);
            if(value[0] == value[1]) {
                System.out.println("Números iguais nos dados, jogando novamente... ");
                value = Arrays.stream(PlayDice.go(playerID)).toArray();
                sum += value[0] + value[1];
                System.out.println("Dados " + value[0] + " e " + value[1]);
            }
            this.position += sum;
        } while (value[0] == value[1]);
    }
}


