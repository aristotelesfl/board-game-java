package models;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Player {
    private int rounds;
    private final int id;
    protected int position;
    boolean isWinner = false;
    private boolean canPlay = true;
    public Player(int id, int position, int rounds) {
        this.id = id;
        this.position = position;
        this.rounds = rounds;
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
    public void addRounds() {rounds += 1;}
    public int getRounds() {return rounds;}
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
