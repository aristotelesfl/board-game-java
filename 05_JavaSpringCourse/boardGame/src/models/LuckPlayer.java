package models;

import utils.PlayDice;

import java.util.Arrays;

public class LuckPlayer extends Player {

    @Override
    public void playDice(){
        int []value = Arrays.stream(PlayDice.go()).toArray();
        do {
            int sum = value[0] + value[1];
            while (sum <= 7) {
                value = Arrays.stream(PlayDice.go()).toArray();
                sum = value[0] + value[1];
            }
            if(value[0] == value[1]) {
                System.out.println("Números iguais nos dados, jogando novamente... ");
                value = Arrays.stream(PlayDice.go()).toArray();
                sum += value[0] + value[1];
            }
            this.position += sum;
        } while (value[0] == value[1]);
    }
}
