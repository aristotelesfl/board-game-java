package utils;

import java.util.random.RandomGenerator;

public class PlayDice {
    public static int[] go(int playerID){
    int[] dados = new int[2];
    System.out.printf("O" + ColorMap.colorMap(playerID, " Player %d ") + "esta lançando os dados...\n", playerID);
        while (true) {
            for (int i=0; i<2; i++){
                dados[i] = RandomGenerator.getDefault().nextInt(1, 7);
            }
            System.out.println("Dados " + dados[0] + " e " + dados[1]);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            if(dados[0] == dados[1]){
                System.out.println("Dados iguais: ");
                System.out.printf("O" + ColorMap.colorMap(playerID, " Player %d ") + "esta lançando os dados novamente...\n", playerID);
                continue;
            }
            break;
        }
        return dados;
    }
}
