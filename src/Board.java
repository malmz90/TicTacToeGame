public class Board {
    private char[] board;
    private final int SIZE = 9;

    public Board() {
        board = new char[SIZE];  // Create a 1D array with 9 cells
      resetBoard();
    }

    // Method to reset the board to empty spaces
    public void resetBoard() {
        for (int i = 0; i < SIZE; i++) {
            board[i] = ' ';  // Set each cell to an empty space
        }
    }

    // Method to display the board
    public void displayBoard() {

        System.out.println("Current board:");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" " + board[i]);  // Print each cell
            if ((i + 1) % 3 == 0) {  // After every third element, move to the next line
                System.out.println();
                if (i < SIZE - 1) {
                    System.out.println("-----------");  // Add a separator between rows
                }
            } else {
                System.out.print(" |");  // Add a vertical separator between cells
            }
        }
    }
}