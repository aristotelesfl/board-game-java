package models;

import utils.PlayDice;

import java.util.Arrays;

public class LuckPlayer extends Player {
    public LuckPlayer(int id, int position, int rounds) {
        super(id, position, rounds);
    }

    @Override
    public void playDice(int playerID){
        int value = Arrays.stream(PlayDice.go(playerID)).sum();
        while (value<7) {
            System.out.println("Valor da soma menor que 7, o jogador sortudo tenta novamente!");
            value = Arrays.stream(PlayDice.go(playerID)).sum();
        }
        addRounds();
        this.position += value;
    }
}
