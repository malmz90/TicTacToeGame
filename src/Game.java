import java.util.Scanner;

import java.util.Random;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;
    private Random random;

    public Game() {
        board = new Board();
        scanner = new Scanner(System.in);
        random = new Random();

        // Prompt for player names
        System.out.print("Enter name for Player 1 (X): ");
        String player1Name = scanner.nextLine();
        player1 = new Player(player1Name, 'X', false);

        // Choose whether Player 2 is human or AI
        System.out.print("Do you want to play against a computer? (yes/no): ");
        String playWithAi = scanner.nextLine();

        if (playWithAi.equals("yes")) {
            player2 = new Player("Computer", 'O', true);
        } else {
            System.out.print("Enter name for Player 2 (O): ");
            String player2Name = scanner.nextLine();
            player2 = new Player(player2Name, 'O', false);
        }

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

            int position = currentPlayer.isAI() ? getAIMove() : validatePlayerMove();  // Check if current player is AI

            // Make the move
            board.makeMove(position, currentPlayer.getSymbol());

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
        }
    }

    // Method for the AI to randomly select a valid move
    private int getAIMove() {
        int position;
        do {
            position = random.nextInt(9) + 1;  // Generate random number between 1 and 9
        } while (!board.makeMove(position, currentPlayer.getSymbol()));
        return position;
    }

    // Method to validate player's move
    private int validatePlayerMove() {
        int position = -1;
        while (true) {
            System.out.print("Enter a position (1-9): ");
            try {
                position = scanner.nextInt();
                if (position >= 1 && position <= 9 && board.makeMove(position, currentPlayer.getSymbol())) {
                    return position;
                } else {
                    System.out.println("Invalid move. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();  // Clear the invalid input
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
