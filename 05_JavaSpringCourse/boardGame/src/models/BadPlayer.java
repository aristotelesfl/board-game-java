package models;

import utils.PlayDice;

import java.util.Arrays;

public class BadPlayer extends Player {

    public BadPlayer(int id, int position, int rounds) {
        super(id, position, rounds);
    }
    @Override
    public void playDice(int playerID){
        int value = Arrays.stream(PlayDice.go(playerID)).sum();
        while (value>7) {
            System.out.println("Valor da soma maior que 7, o jogador azarado é obrigado a repetir!");
            value = Arrays.stream(PlayDice.go(playerID)).sum();
        }
        addRounds();
        this.position += value;
    }

}
