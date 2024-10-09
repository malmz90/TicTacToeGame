public class Board {
    private char[] board;
    private int SIZE = 9;

    public Board() {
        board = new char[SIZE];
      resetBoard();
    }

    // Method reset the board to empty spaces
    public void resetBoard() {
        for (int i = 0; i < SIZE; i++) {
            board[i] = ' ';
        }
    }

//    Method to display the boards current state
    public void displayBoard() {
        System.out.println("Current board:");

        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("-----------");

        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("-----------");

        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
    }

//    Method to place symbol at position.
    public boolean makeMove(int position, char symbol) {
        // Check if the position is valid (1-9) and the cell is empty
        if (position >= 1 && position <= 9 && board[position - 1] == ' ') {
            board[position - 1] = symbol;
            return true;
        }
        return false;
    }

    // Method to check if the board is full
    public boolean isFull() {
        for (char position : board) {
            if (position == ' ') {
                return false;
        }
        }
        return true;
    }

    // Method to check for a win
    public boolean checkWin(char symbol) {
        // Check rows
        if (board[0] == symbol && board[1] == symbol && board[2] == symbol) return true;
        if (board[3] == symbol && board[4] == symbol && board[5] == symbol) return true;
        if (board[6] == symbol && board[7] == symbol && board[8] == symbol) return true;

        // Check columns
        if (board[0] == symbol && board[3] == symbol && board[6] == symbol) return true;
        if (board[1] == symbol && board[4] == symbol && board[7] == symbol) return true;
        if (board[2] == symbol && board[5] == symbol && board[8] == symbol) return true;

        // Check diagonals
        if (board[0] == symbol && board[4] == symbol && board[8] == symbol) return true;
        if (board[2] == symbol && board[4] == symbol && board[6] == symbol) return true;


        return false;
    }


}