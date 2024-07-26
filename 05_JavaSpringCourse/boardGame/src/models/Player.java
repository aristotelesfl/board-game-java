package models;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Player {
    private final int id;
    protected int position = 0;
    private boolean isWinner = false;

    private boolean canPlay = true;
    public Player(int id, int position) {
        this.id = id;
        this.position = position;
    }
    public abstract void playDice(int playerID);
    public int getPosition() {
        return position;
    }
    public void setPosition(int position){
        this.position = 0;
    }
    public void luckMove() {
        this.position += 3;
    }
    public int getId(){
        return id;
    }

    public boolean isWinner() {
        return isWinner;
    }
    public void setCanPlay(boolean canPlay) {
        this.canPlay = canPlay;
    }
    public boolean isCanPlay() {
        return canPlay;
    }
}
