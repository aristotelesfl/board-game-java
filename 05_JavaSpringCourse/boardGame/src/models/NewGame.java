package models;

import rules.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NewGame {
    boolean isWinner;
    Scanner input = new Scanner(System.in);
    public void start(){
        int numberOfPlayers = selectNumberOfPlayers();
        ArrayList<Player> listOfPlayers = new ArrayList();
        for (int i=0; i<numberOfPlayers; i++){
            selectPlayerType(listOfPlayers, i+1);

        }
        while (!endGame(listOfPlayers)) {
            playRound(listOfPlayers);
        }
    }

    private int selectNumberOfPlayers(){
        int numberOfPlayers;
        while(true) {
            System.out.println("(min = 2, max = 6)");
            System.out.print("Selecione a quantidade de jogadores: ");
            try {
                numberOfPlayers = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("O valor digitado deve ser um inteiro!");
                continue;
            }
            if (numberOfPlayers < 2 || numberOfPlayers > 6) System.out.println("Inválido: a quantidade de players deve estar entre 2 e 6!");
            else break;
        }
        return numberOfPlayers;
    }
    private void selectPlayerType(ArrayList<Player> listOfPlayers, int indexOfPlayer){
        int typeOfPlayer;
        Player player;
        System.out.println("""
                Tipos de jogador:
                1 - Jogador normal
                2 - Jogador sortudo
                3 - Jogador azarado""");
        while (true) {
            System.out.printf("Selecione o tipo do player %d: ", indexOfPlayer);
            try {
                typeOfPlayer = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("O valor digitado deve ser um inteiro!");
                continue;
            }
            switch (typeOfPlayer) {
                case 1 -> {
                    player = new NormalPlayer(indexOfPlayer, 0);
                }
                case 2 -> {
                    player = new LuckPlayer(indexOfPlayer, 0);
                }
                case 3 -> {
                    player = new BadPlayer(indexOfPlayer, 0);
                }
                default -> {
                    System.out.println("Inválido: Selecione um tipo de 1 a 3!");
                    continue;
                }
            }
            if (indexOfPlayer==2 && listOfPlayers.get(0).getClass() == player.getClass()) {
                System.out.println("Os jogadores devem ter tipos diferentes. Selecione um novo tipo para o jogador 2.");
                continue;
            }
            break;
        }
        listOfPlayers.add(player);
    }

    private void playRound(ArrayList<Player> listOfPlayers) {
        for (Player player : listOfPlayers) {
            System.out.printf("\nPosição do Player %d: %d\n\n", player.getId(), player.getPosition());
            if (player.isCanPlay()) {
                player.playDice(player.getId());
                specialCases(listOfPlayers, player);
            }
            else {
                System.out.printf("O Player %d pulou a rodada.", player.getId());
                player.setCanPlay(true);
            }
        }
    }

    private static void specialCases(ArrayList listOfPlayers, Player currentPlayer) {
        switch (currentPlayer.getPosition()) {
            case 10, 25, 38 -> SkipRule.apply(currentPlayer);
            case 13 -> SurpriseRule.apply(currentPlayer);
            case 5, 15, 30 -> LuckRule.apply(currentPlayer);
            case 17, 27 -> RestartRule.apply(listOfPlayers, currentPlayer);
            case 20, 35 -> MagicRule.apply(listOfPlayers, currentPlayer);
        }
    }

    private boolean endGame(ArrayList<Player> listOfPlayers) {
        for (Player player : listOfPlayers){
            if (player.isWinner()) {
                return true;
            }
        }
        return false;
    }
}
