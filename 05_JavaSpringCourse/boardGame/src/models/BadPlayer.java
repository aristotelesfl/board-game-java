package models;

import utils.PlayDice;

import java.util.Arrays;

public class BadPlayer extends Player {

    public BadPlayer(){
        super();
    }
    public BadPlayer(int id, int position) {
        super(id, position);
    }
    @Override
    public void playDice(int playerID){
//        int value = Arrays.stream(PlayDice.go(playerID)).sum();
//        int[] dados = Arrays.stream(PlayDice.go(playerID)).toArray();
//
//        while (value>=7) {
//            value = Arrays.stream(PlayDice.go(playerID)).sum();
//        }
//        System.out.printf("O Player %d esta lançando os dados...\n", playerID);
//        System.out.println("Dados " + dados[0] + " e " + dados[1]);
//        this.position += value;
        int []value = Arrays.stream(PlayDice.go(playerID)).toArray();

        System.out.printf("O Player %d esta lançando os dados...\n", playerID);
        do {
            int sum = value[0] + value[1];
            while (sum >= 7) {
                value = Arrays.stream(PlayDice.go(playerID)).toArray();
                sum = value[0] + value[1];
            }
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

