import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;

    public Game() {
        board = new Board();
        player1 = new Player("Player 1", 'X');
        player2 = new Player("Player 2", 'O');
        currentPlayer = player1;
        scanner = new Scanner(System.in);
    }

    // Method to start the game and keep it running
    public void start() {
        while (true) {
            playRound();
            resetGame();  // Automatically reset the game after each round
        }
    }

    //  Method to play a round of tictactoe
    private void playRound() {
        while (true) {
            board.displayBoard();
            // Prompt current player for move
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");
            System.out.print("Enter a position (1-9): ");
            int position = scanner.nextInt();

            if (board.makeMove(position, currentPlayer.getSymbol())) {
                // Check for win condition
                if (board.checkWin(currentPlayer.getSymbol())) {
                    board.displayBoard();
                    System.out.println(currentPlayer.getName() + " wins!");
                    break;
                }
                // Check for draw
                else if (board.isFull()) {
                    board.displayBoard();
                    System.out.println("It's a draw!");
                    break;
                }
                switchPlayer();
            } else {
                // Handle invalid move
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    private void resetGame() {
        board.resetBoard();  // Reset the board
        currentPlayer = player1;  // Player 1 always starts first
    }
}
