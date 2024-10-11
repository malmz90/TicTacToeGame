public class Player {
    private char symbol;
    private String name;
    private int wins;
    private boolean isAI;

    public Player(String name, char symbol, boolean isAI) {
        this.name = name;
        this.symbol = symbol;
        this.wins = 0;
        this.isAI = isAI;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public void incrementWins() {
        this.wins++;
    }

    public boolean isAI() {
        return isAI;
    }
}
