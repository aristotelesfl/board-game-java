package models;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Player {
    private static final AtomicInteger globalIdCounter = new AtomicInteger(0);
    private final int id;
    protected int position = 0;
    public Player() {
        this.id = globalIdCounter.incrementAndGet();
    }
    public abstract void playDice();
    public int getPosition() {
        return position;
    }
    public void setPosition(int position){
        this.position = 0;
    }
    public void move() {
        this.position += 3;
    }
    public int getId(){
        return id;
    }
}
