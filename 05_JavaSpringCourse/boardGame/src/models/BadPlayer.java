package models;

import utils.PlayDice;

import java.util.Arrays;

public class BadPlayer extends NormalPlayer {
    @Override
    public void playDice(){
        int value = Arrays.stream(PlayDice.go()).sum();
        while (value>=7) {
            value = Arrays.stream(PlayDice.go()).sum();
        }
        this.position += value;
    }

}
