import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;

    public Game() {
        board = new Board();
        scanner = new Scanner(System.in);

        // Prompt for player names
        System.out.print("Enter name for Player 1 (X): ");
        String player1Name = scanner.nextLine();
        player1 = new Player(player1Name, 'X');

        System.out.print("Enter name for Player 2 (O): ");
        String player2Name = scanner.nextLine();
        player2 = new Player(player2Name, 'O');

        currentPlayer = player1;
    }

    // Method to start the game and keep it running
    public void start() {
        while (true) {
            playRound();
            displayScore();
            resetGame();  // Automatically reset the game after each round
        }
    }

    //  Method to play a round of tictactoe
    private void playRound() {
        while (true) {
            board.displayBoard();
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");

            int position = validatePlayerMove();

            if (board.makeMove(position, currentPlayer.getSymbol())) {
                // Check for win condition
                if (board.checkWin(currentPlayer.getSymbol())) {
                    board.displayBoard();
                    System.out.println(currentPlayer.getName() + " wins!");
                    currentPlayer.incrementWins();  // Increment win count for the current player
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
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private int validatePlayerMove() {
        int position = -1;
        while (true) {
            System.out.print("Enter a position (1-9): ");
            try {
                position = scanner.nextInt();
                if (position >= 1 && position <= 9) {
                    return position;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 9.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();  // Clear the invalid input to prevent an infinite loop
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

    private void displayScore() {
        System.out.println("\nCurrent Score:");
        System.out.println(player1.getName() + " (X): " + player1.getWins() + " wins");
        System.out.println(player2.getName() + " (O): " + player2.getWins() + " wins\n");
    }
}
