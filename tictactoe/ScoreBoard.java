package tictactoe;

import java.util.Map;

public class ScoreBoard implements GameObserver {
    Map<Player, Integer> scores;

    public ScoreBoard() {
        scores = new java.util.HashMap<>();
    }

    void printScores() {
        for (Map.Entry<Player, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }
    }

    public void update(Game game) {
        if(game.gameState == GameState.WON) {
            Player winner = game.winner;
            scores.put(winner, scores.getOrDefault(winner, 0) + 1);
        }
    }
}
