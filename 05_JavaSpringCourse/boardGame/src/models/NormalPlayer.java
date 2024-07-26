package models;

import utils.PlayDice;
import java.util.Arrays;

public class NormalPlayer extends Player {
    public NormalPlayer(int id, int position) {
        super(id, position);
    }

    @Override
    public void playDice(int playerID) {
        this.position += Arrays.stream(PlayDice.go(playerID)).sum();
    }

}
