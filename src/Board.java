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

        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("-----------");

        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("-----------");

        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
    }
}