package tictactoe;

public class DiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, char mark) {
        // Check main diagonal
        if (board.getMark(0, 0) == mark && board.getMark(1, 1) == mark && board.getMark(2, 2) == mark) {
            return true;
        }
        // Check anti-diagonal
        if (board.getMark(0, 2) == mark && board.getMark(1, 1) == mark && board.getMark(2, 0) == mark) {
            return true;
        }
        return false;
    }
}
