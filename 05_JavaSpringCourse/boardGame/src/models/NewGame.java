package models;

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
                case 1 -> listOfPlayers.add(new NormalPlayer());
                case 2 -> listOfPlayers.add(new LuckPlayer());
                case 3 -> listOfPlayers.add(new BadPlayer());
                default -> {
                    System.out.println("Inválido: Selecione um tipo de 1 a 3!");
                    continue;
                }
            }
            break;
        }
    }
    private void playRound(ArrayList<Player> listOfPlayers) {
        for (Player player : listOfPlayers) {
            Board.generateBoard(listOfPlayers);
            if (player.isCanPlay()) player.playDice(player.getId());
            else player.setCanPlay(true);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
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
