package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game extends GameSubject {
    Player player1;
    Player player2;
    Board board;
    Player currentPlayer;
    GameState gameState;
    List<WinningStrategy> winnerStrategies = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Player winner;

    public Game(Player player1, Player player2, List<WinningStrategy> winnerStrategies) {
        this.player1 = player1;
        this.player2 = player2;
        this.winnerStrategies = winnerStrategies;
        this.board = new Board();
        this.currentPlayer = player1;
        this.gameState = GameState.PLAYING;
    }

    public void start() {
        // Game loop and logic would go here
        while(gameState == GameState.PLAYING) {
            // Players take turns to place marks
            // Check for winner after each turn
            // If a player wins, set winnerFound to true
            if(board.isFull()) {
                System.out.println("The board is full. It's a draw!");
                gameState = GameState.DRAW;
                continue;
            }
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (board.chanceAvailable()) {
                if(board.isValidMove(row, col)) {
                    board.placeMark(row, col, currentPlayer.getMark());
                    // Check for winner
                    System.out.println("Player " + currentPlayer.getName() + " placed mark at (" + row + ", " + col + ")");
                    // Check for winner logic would go here
                    boolean isWinner = false;
                    for (WinningStrategy strategy : winnerStrategies) {
                        if (strategy.checkWinner(board, currentPlayer.getMark())) {
                            System.out.println("Player " + currentPlayer.getName() + " wins in " + strategy.getClass().getSimpleName() + "!");
                            isWinner = true;
                        }
                    }
                    if(isWinner) {
                        System.out.println("Player " + currentPlayer.getName() + " wins!");
                        gameState = GameState.WON;
                        notifyObservers(this);
                    }
                } else {
                    System.out.println("Invalid move. Please try again.");
                    break;
                }
            }

            switch (gameState) {
                case WON:
                    System.out.println("Game Over! Player " + currentPlayer.getName() + " wins!");
                    winner = currentPlayer;
                    break;
                default:
                    // switch players
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;
                    board.printBoard();
            }
        }
    }
}
