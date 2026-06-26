package tictactoe;

public interface WinningStrategy {
    public boolean checkWinner(Board board, char mark);
}
