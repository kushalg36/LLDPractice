package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeSystem {
    public static void main(String[] args) {
        Player player1 = new Player("Player 1", 'X');
        Player player2 = new Player("Player 2", 'O');
        WinningStrategy rowWinningStrategy = new RowWinningStrategy();
        WinningStrategy columnWinningStrategy = new ColumnWinningStrategy();
        WinningStrategy diagonalWinningStrategy = new DiagonalWinningStrategy();
        List<WinningStrategy> winnerStrategies = new ArrayList<>();
        winnerStrategies.add(rowWinningStrategy);
        winnerStrategies.add(columnWinningStrategy);
        winnerStrategies.add(diagonalWinningStrategy);
        Game game = new Game(player1, player2, winnerStrategies);
        game.start();
    }
}