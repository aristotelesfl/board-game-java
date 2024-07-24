package Game;

import models.*;
import rules.*;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.random.RandomGenerator;

public class NewGame implements GameMode {
    @Override
    public void playGame(int qtdPlayer) {
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < qtdPlayer; i++) {
            int typePlayer = RandomGenerator.getDefault().nextInt(1, 4);
            if(typePlayer == 1) {
                players.add(new LuckPlayer());
            } else if(typePlayer == 2) {
                players.add(new BadPlayer());
            } else {
                players.add(new NormalPlayer());
            }
        }
        Board.generateBoard(players);
        for (AtomicInteger i = new AtomicInteger(0); i.get() != 40 ; i.get()){
            players.forEach(p -> {
                System.out.println("Player " + p.getId() + " jogando:");
                p.playDice();
                Board.generateBoard(players);
                switch (p.getPosition()) {
                    case 5, 15, 30 -> {
                        LuckRule.apply(p);
                    }
                    case 10, 25, 38 -> {
                        SkipRule.skip(p);
                    }
                    case 13 -> {
                        SurpriseRule.apply(p);
                    }
                    case 17, 27 -> {
                        RestartRule.apply(players, p);
                    }
                    case 20, 35 -> {
                        MagicRule.apply(players, p);
                    }
                    case 40 -> {
                        System.out.println("Player " + p.getId() + " wins");
                        i.set(40);
                    }
                }
            });
        }
    }

}
