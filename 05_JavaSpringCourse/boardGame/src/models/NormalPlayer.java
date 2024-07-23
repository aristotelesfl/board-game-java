package models;

import utils.PlayDice;
import java.util.Arrays;

public class NormalPlayer extends Player {
    @Override
    public void playDice() {
        this.position += Arrays.stream(PlayDice.go()).sum();
    }

}
