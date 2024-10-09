public class Player {
    private char symbol;
    private String name;
    private int wins;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.wins = 0;
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
}
