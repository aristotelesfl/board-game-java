package utils;

public class ColorMap {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CIANO = "\u001B[36m";


    public static String colorMap(int id, String texto) {
        String colorCode = switch (id) {
            case 1 -> GREEN;
            case 2 -> YELLOW;
            case 3 -> BLUE;
            case 4 -> CIANO;
            case 5 -> RED;
            case 6 -> PURPLE;
            default -> null;
        };

        return colorCode + texto + RESET;
    }
}
