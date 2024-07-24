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
        int value = Arrays.stream(PlayDice.go(playerID)).sum();
        while (value>=7) {
            value = Arrays.stream(PlayDice.go(playerID)).sum();
        }
        this.position += value;
    }

}
