package models;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Player {
    private final AtomicInteger rounds = new AtomicInteger(0);
    private final int id;
    protected int position;
    boolean isWinner = false;
    private boolean canPlay = true;
    public Player(int id, int position) {
        this.id = id;
        this.position = position;
    }
    public abstract void playDice(int playerID);
    public int getPosition() {
        return position;
    }
    public void setPosition(){
        this.position = 0;
    }
    public void luckMove() {
        this.position += 3;
    }
    public int getId(){
        return id;
    }
    public void nextRoud() {rounds.incrementAndGet();}
    public AtomicInteger getRounds() {return rounds;}
    public void setWinner(){
        isWinner = true;
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
